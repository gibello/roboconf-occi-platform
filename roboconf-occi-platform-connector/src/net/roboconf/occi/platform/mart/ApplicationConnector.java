/**
 * Copyright (c) 2016-2017 Inria
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * - Philippe Merle <philippe.merle@inria.fr>
 * - Faiez Zalila <faiez.zalila@inria.fr>
 *
 * Generated at Tue Sep 12 13:55:57 CEST 2017 from platform:/plugin/org.eclipse.cmf.occi.platform/model/Platform.occie by org.eclipse.cmf.occi.core.gen.connector
 */
package net.roboconf.occi.platform.mart;

import java.util.logging.Logger;

import net.roboconf.core.model.beans.Instance;
import net.roboconf.core.model.beans.Instance.InstanceStatus;
import net.roboconf.dm.rest.client.WsClient;
import net.roboconf.dm.rest.client.exceptions.ApplicationWsException;
import net.roboconf.dm.rest.commons.json.JSonBindingUtils;

import java.net.URL;
import java.util.List;

import org.eclipse.cmf.occi.core.Configuration;
import org.eclipse.cmf.occi.core.Extension;
import org.eclipse.cmf.occi.core.Kind;
import org.eclipse.cmf.occi.core.util.OcciHelper;
import org.eclipse.cmf.occi.platform.Component;
import org.eclipse.cmf.occi.platform.Status;
import org.eclipse.emf.common.util.EList;

/**
 * Connector implementation for the OCCI kind:
 * - scheme: http://schemas.ogf.org/occi/platform#
 * - term: application
 * - title: Application
 */
public class ApplicationConnector extends org.eclipse.cmf.occi.platform.impl.ApplicationImpl
{
	WsClient client;
	String applicationName = "occiware-test-application";
	Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * Constructs a application connector.
	 */
	ApplicationConnector()
	{
		logger.info("Constructor called on " + this);
	}

	//
	// OCCI CRUD callback operations.
	//

	/**
	 * Called when this Application instance is completely created.
	 */
	@Override
	public void occiCreate()
	{
		logger.info("occiCreate() called on application with name=" + this.getOcciAppName());
		String name = this.getOcciAppName();
		if(name != null && name.trim().length() > 0) this.applicationName = name.trim();

		String roboconfUrl = "http://localhost:8181/roboconf-dm";
		URL context = this.getOcciAppContext();
		if(context != null) {
			roboconfUrl = context.toExternalForm();
		}
		this.client = new WsClient(roboconfUrl);
	
		Configuration config = OcciHelper.getConfiguration(this);

		EList<Extension> extensions = config.getUse();
		Extension currentExt = null;
		for (Extension ext : extensions) {
			logger.info("Extension found: " + ext.getName());
			if (ext.getName().equalsIgnoreCase("platform")) {
				currentExt = ext;
				break;
			}
		}

		if (currentExt != null) {
			logger.info("Platform extension is available, calling roboconf on " + roboconfUrl);

			// Discover instances in Roboconf application...
			// then populate OCCI:platform components
			List<Instance> instances = this.client.getApplicationDelegate().listChildrenInstances(this.applicationName, null, true);
			Kind componentKind = OcciHelper.getKindByTerm(currentExt, "component");
			
			int count = 1;
			for(Instance instance : instances) {
				String path = instance.data.get(JSonBindingUtils.AT_INSTANCE_PATH);
				logger.info("Roboconf instance found: " + path);
				Component component = (Component)OcciHelper.createEntity(componentKind);
				//component.setLocation("/component/" + path.substring(1).replaceAll("/", "").replaceAll("\\s+", ""));
				component.setLocation("/component/" + count++);
				InstanceStatus stat = instance.getStatus();
				component.setOcciComponentState(stat == InstanceStatus.DEPLOYED_STARTED ? Status.ACTIVE : Status.INACTIVE);
				// Using Title, Message and Summary URL to pass context information...
				// Should improve OCCI:Platform spec ?
				component.setTitle(path);
				component.setOcciComponentStateMessage(this.applicationName);
				component.setSummary(roboconfUrl);
				config.getResources().add(component);
				logger.info("OCCI Platform Component created: " + component);
			}
		}
		
		this.setOcciAppState(Status.ACTIVE);
	}

	/**
	 * Called when this Application instance must be retrieved.
	 */
	@Override
	public void occiRetrieve()
	{
		logger.info("occiRetrieve() called on " + this);

		// TODO: Implement this callback or remove this method.
	}

	/**
	 * Called when this Application instance is completely updated.
	 */
	@Override
	public void occiUpdate()
	{
		logger.info("occiUpdate() called on " + this + ": method NOT IMPLEMENTED !");

		// TODO: Implement this callback or remove this method.
	}

	/**
	 * Called when this Application instance will be deleted.
	 */
	@Override
	public void occiDelete()
	{
		logger.info("occiDelete() called on " + this + ": method NOT IMPLEMENTED !");

		// TODO: Implement this callback or remove this method.
	}

	//
	// Application actions.
	//

	/**
	 * Implement OCCI action:
     * - scheme: http://schemas.ogf.org/occi/platform/application/action#
     * - term: start
     * - title: Start the application.
	 */
	@Override
	public void start()
	{
		logger.info("Action start() called on " + this + ", starting ALL instances !");

		if(this.client != null) {
			try {
				this.client.getApplicationDelegate().deployAndStartAll(this.applicationName, null);
				this.setOcciAppState(Status.ACTIVE);
			} catch (ApplicationWsException e) {
				e.printStackTrace(System.err);
			}
		}
	}

	/**
	 * Implement OCCI action:
     * - scheme: http://schemas.ogf.org/occi/platform/application/action#
     * - term: stop
     * - title: Stop the application.
	 */
	@Override
	public void stop()
	{
		logger.info("Action stop() called on " + this +", stopping ALL instances !" );

		if(this.client != null) {
			try {
				this.client.getApplicationDelegate().undeployAll(this.applicationName, null);
				this.setOcciAppState(Status.INACTIVE);
			} catch (ApplicationWsException e) {
				e.printStackTrace(System.err);
			}
		}
	}

}	

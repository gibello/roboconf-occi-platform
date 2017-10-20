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

import org.modmacao.occi.platform.Status;

import net.roboconf.core.model.beans.Instance.InstanceStatus;
import net.roboconf.dm.rest.client.WsClient;
import net.roboconf.dm.rest.client.exceptions.ApplicationWsException;
/**
 * Connector implementation for the OCCI kind:
 * - scheme: http://schemas.ogf.org/occi/platform#
 * - term: component
 * - title: Component
 */
public class ComponentConnector extends org.modmacao.occi.platform.impl.ComponentImpl
{
	String applicationName = "occiware-test-application";
	Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * Constructs a component connector.
	 */
	ComponentConnector()
	{
		logger.info("Constructor called on " + this);
	}

	//
	// OCCI CRUD callback operations.
	//

	/**
	 * Called when this Component instance is completely created.
	 */
	@Override
	public void occiCreate()
	{
		logger.info("occiCreate() called on " + this);
	}

	/**
	 * Called when this Component instance must be retrieved.
	 */
	@Override
	public void occiRetrieve()
	{
		logger.info("occiRetrieve() called on " + this);

		// TODO: Implement this callback or remove this method.
	}

	/**
	 * Called when this Component instance is completely updated.
	 */
	@Override
	public void occiUpdate()
	{
		logger.info("occiUpdate() called on " + this);

		// TODO: Implement this callback or remove this method.
	}

	/**
	 * Called when this Component instance will be deleted.
	 */
	@Override
	public void occiDelete()
	{
		logger.info("occiDelete() called on " + this);

		// TODO: Implement this callback or remove this method.
	}

	//
	// Component actions.
	//

	/**
	 * Implement OCCI action:
     * - scheme: http://schemas.ogf.org/occi/platform/component/action#
     * - term: deploy
     * - title: Deploy the application.
	 */
	@Override
	public void deploy()
	{
		logger.info("Action deploy() called on " + this);

		try {
			WsClient client = new WsClient(getRoboconfUrl());
			client.getApplicationDelegate().changeInstanceState(this.getOcciComponentStateMessage(),
					InstanceStatus.DEPLOYED_STOPPED, this.getTitle());
			this.setOcciComponentState(Status.INACTIVE);
		} catch (ApplicationWsException e) {
			e.printStackTrace(System.err);
		}
	}
	
	/**
	 * Implement OCCI action:
     * - scheme: http://schemas.ogf.org/occi/platform/component/action#
     * - term: start
     * - title: Start the application.
	 */
	@Override
	public void start()
	{
		logger.info("Action start() called on " + this);

		try {
			WsClient client = new WsClient(getRoboconfUrl());
			client.getApplicationDelegate().changeInstanceState(this.getOcciComponentStateMessage(),
					InstanceStatus.DEPLOYED_STARTED, this.getTitle());
			this.setOcciComponentState(Status.ACTIVE);
		} catch (ApplicationWsException e) {
			e.printStackTrace(System.err);
		}
	}

	/**
	 * Implement OCCI action:
     * - scheme: http://schemas.ogf.org/occi/platform/component/action#
     * - term: stop
     * - title: Stop the application.
	 */
	@Override
	public void stop()
	{
		logger.info("Action stop() called on " + this);

		try {
			WsClient client = new WsClient(getRoboconfUrl());
			client.getApplicationDelegate().changeInstanceState(this.getOcciComponentStateMessage(),
					InstanceStatus.DEPLOYED_STOPPED, this.getTitle());
			this.setOcciComponentState(Status.INACTIVE);
		} catch (ApplicationWsException e) {
			e.printStackTrace(System.err);
		}

	}

	/**
	 * Implement OCCI action:
     * - scheme: http://schemas.ogf.org/occi/platform/component/action#
     * - term: undeploy
     * - title: Undeploy the application.
	 */
	@Override
	public void undeploy()
	{
		logger.info("Action undeploy() called on " + this);

		try {
			WsClient client = new WsClient(getRoboconfUrl());
			client.getApplicationDelegate().changeInstanceState(this.getOcciComponentStateMessage(),
					InstanceStatus.NOT_DEPLOYED, this.getTitle());
			this.setOcciComponentState(Status.UNDEPLOYED);
		} catch (ApplicationWsException e) {
			e.printStackTrace(System.err);
		}

	}
	
	/**
	 * Retrieves Roboconf URL
	 * @return The URL of Roboconf DM
	 */
	private String getRoboconfUrl() {
		String url = this.getSummary();
		if(url == null) url = "http://localhost:8181/roboconf-dm";
		return url;
	}

	/* TEST main...
	public static void testOcciCreate() {
		System.out.println("occiCreate() called on " + "test");
		try {
			WsClient client = new WsClient("http://localhost:8181/roboconf-dm");
			client.getApplicationDelegate().changeInstanceState("apache-bash", InstanceStatus.DEPLOYED_STARTED, "/Apache on CA" );
		} catch (ApplicationWsException e) {
			e.printStackTrace(System.err);
		}
	}
	public static void main(String args[]) throws Exception {
		ComponentConnector.testOcciCreate();
	}*/
}	

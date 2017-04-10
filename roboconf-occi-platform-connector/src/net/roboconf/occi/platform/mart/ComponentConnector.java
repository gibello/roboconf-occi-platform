/**
 * Copyright 2016 Linagora
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Generated at Tue Dec 13 14:38:08 CET 2016 from 
// platform:/plugin/org.occiware.clouddesigner.occi.platform/model/platform.occie by org.occiware.clouddesigner.occi.gen.connector
package net.roboconf.occi.platform.mart;

import java.util.logging.Logger;

import org.occiware.clouddesigner.occi.platform.Status;

import net.roboconf.core.model.beans.Instance.InstanceStatus;
import net.roboconf.dm.rest.client.WsClient;
import net.roboconf.dm.rest.client.exceptions.ApplicationWsException;

/**
 * Connector implementation for the OCCI kind:
 * - scheme: http://schemas.ogf.org/occi/platform#
 * - term: component
 * - title: Component
 */
public class ComponentConnector extends org.occiware.clouddesigner.occi.platform.impl.ComponentImpl
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
     * - term: start
     * - title: Start the application.
	 */
	@Override
	public void start()
	{
		logger.info("Action start() called on " + this);

		try {
			WsClient client = new WsClient(getRoboconfUrl());
			client.getApplicationDelegate().changeInstanceState(this.getMessage(),
					InstanceStatus.DEPLOYED_STARTED, this.getTitle());
			this.setState(Status.ACTIVE);
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
			client.getApplicationDelegate().changeInstanceState(this.getMessage(),
					InstanceStatus.NOT_DEPLOYED, this.getTitle());
			this.setState(Status.INACTIVE);
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

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

/**
 * Connector implementation for the OCCI kind:
 * - scheme: http://schemas.ogf.org/occi/platform#
 * - term: componentlink
 * - title: ComponentLink
 */
public class ComponentlinkConnector extends org.occiware.clouddesigner.occi.platform.impl.ComponentlinkImpl
{
	/**
	 * Constructs a componentlink connector.
	 */
	ComponentlinkConnector()
	{
		System.out.println("Constructor called on " + this);
	}

	//
	// OCCI CRUD callback operations.
	//

	/**
	 * Called when this Componentlink instance is completely created.
	 */
	@Override
	public void occiCreate()
	{
		System.out.println("occiCreate() called on " + this);

		// TODO: Implement this callback or remove this method.
	}

	/**
	 * Called when this Componentlink instance must be retrieved.
	 */
	@Override
	public void occiRetrieve()
	{
		System.out.println("occiRetrieve() called on " + this);

		// TODO: Implement this callback or remove this method.
	}

	/**
	 * Called when this Componentlink instance is completely updated.
	 */
	@Override
	public void occiUpdate()
	{
		System.out.println("occiUpdate() called on " + this);

		// TODO: Implement this callback or remove this method.
	}

	/**
	 * Called when this Componentlink instance will be deleted.
	 */
	@Override
	public void occiDelete()
	{
		System.out.println("occiDelete() called on " + this);

		// TODO: Implement this callback or remove this method.
	}

	//
	// Componentlink actions.
	//

}	

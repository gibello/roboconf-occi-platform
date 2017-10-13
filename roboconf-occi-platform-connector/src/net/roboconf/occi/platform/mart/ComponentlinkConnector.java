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

/**
 * Connector implementation for the OCCI kind:
 * - scheme: http://schemas.ogf.org/occi/platform#
 * - term: componentlink
 * - title: ComponentLink
 */
public class ComponentlinkConnector extends org.eclipse.cmf.occi.platform.impl.ComponentlinkImpl
{
	/**
	 * Initialize the logger.
	 */
	private static Logger LOGGER = Logger.getLogger(ComponentlinkConnector.class.getName());

	// Start of user code Componentlinkconnector_constructor
	/**
	 * Constructs a componentlink connector.
	 */
	ComponentlinkConnector()
	{
		LOGGER.finest("Constructor called on " + this);
		// TODO: Implement this constructor.
	}
	// End of user code
	//
	// OCCI CRUD callback operations.
	//
	
	// Start of user code ComponentlinkocciCreate
	/**
	 * Called when this Componentlink instance is completely created.
	 */
	@Override
	public void occiCreate()
	{
		LOGGER.finest("occiCreate() called on " + this);
		// TODO: Implement this callback or remove this method.
	}
	// End of user code

	// Start of user code Componentlink_occiRetrieve_method
	/**
	 * Called when this Componentlink instance must be retrieved.
	 */
	@Override
	public void occiRetrieve()
	{
		LOGGER.finest("occiRetrieve() called on " + this);
		// TODO: Implement this callback or remove this method.
	}
	// End of user code

	// Start of user code Componentlink_occiUpdate_method
	/**
	 * Called when this Componentlink instance is completely updated.
	 */
	@Override
	public void occiUpdate()
	{
		LOGGER.finest("occiUpdate() called on " + this);
		// TODO: Implement this callback or remove this method.
	}
	// End of user code

	// Start of user code ComponentlinkocciDelete_method
	/**
	 * Called when this Componentlink instance will be deleted.
	 */
	@Override
	public void occiDelete()
	{
		LOGGER.finest("occiDelete() called on " + this);
		// TODO: Implement this callback or remove this method.
	}
	// End of user code

	//
	// Componentlink actions.
	//
}	

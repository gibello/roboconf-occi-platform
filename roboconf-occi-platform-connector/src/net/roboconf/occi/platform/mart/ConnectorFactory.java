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
 * Connector EFactory for the OCCI extension:
 * - name: platform
 * - scheme: http://schemas.ogf.org/occi/platform#
 */
public class ConnectorFactory extends org.occiware.clouddesigner.occi.platform.impl.PlatformFactoryImpl
{
	/**
	 * EFactory method for OCCI kind:
	 * - scheme: http://schemas.ogf.org/occi/platform#
	 * - term: application
	 * - title: Application
	 */
	@Override
	public org.occiware.clouddesigner.occi.platform.Application createApplication() {
		return new ApplicationConnector();
	}

	/**
	 * EFactory method for OCCI kind:
	 * - scheme: http://schemas.ogf.org/occi/platform#
	 * - term: component
	 * - title: Component
	 */
	@Override
	public org.occiware.clouddesigner.occi.platform.Component createComponent() {
		return new ComponentConnector();
	}

	/**
	 * EFactory method for OCCI kind:
	 * - scheme: http://schemas.ogf.org/occi/platform#
	 * - term: componentlink
	 * - title: ComponentLink
	 */
	@Override
	public org.occiware.clouddesigner.occi.platform.Componentlink createComponentlink() {
		return new ComponentlinkConnector();
	}
}

/**
 *  Copyright (c) 2013-2016 Angelo ZERR and Genuitec LLC.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Piotr Tomiak <piotr@genuitec.com> - initial API and implementation
 */
package tern.server;

import tern.TernException;
import tern.server.protocol.ITernResultsCollector;
import tern.server.protocol.TernDoc;

public interface ITernServerRequestProcessor {

	void processRequest(TernDoc doc, ITernResultsCollector collector)
			throws TernException;

}

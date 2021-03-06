/**
 *  Copyright (c) 2013-2016 Angelo ZERR.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Angelo Zerr <angelo.zerr@gmail.com> - initial API and implementation
 */
package tern.eclipse.ide.core;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;


/**
 * Tern nature adapter, can be used by adopters to provide more
 * advanced logic for which projects should be treated as tern projects
 */
public interface ITernNatureCapability {

	IProject getAlternative( IProject project ) throws CoreException;
	
	boolean hasTernNature( IProject project ) throws CoreException;

}

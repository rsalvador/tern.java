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
package tern.eclipse.ide.jsdt.internal.ui.contentassist;

import org.eclipse.jface.internal.text.html.BrowserInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wst.jsdt.ui.text.java.IJavaCompletionProposal;

import tern.eclipse.ide.ui.contentassist.JSTernCompletionProposal;
import tern.eclipse.ide.ui.hover.IDEHoverControlCreator;
import tern.eclipse.ide.ui.hover.IDEPresenterControlCreator;
import tern.eclipse.ide.ui.hover.TernHover;
import tern.server.protocol.completions.TernCompletionProposalRec;

/**
 * Extends {@link JSTernCompletionProposal} to implements JSDT
 * {@link IJavaCompletionProposal} to set an high relevance for tern completion
 * proposal to display on the top of the completion popup the tern result.
 *
 */
public class JSDTTernCompletionProposal extends JSTernCompletionProposal
		implements IJavaCompletionProposal {

	public JSDTTernCompletionProposal(TernCompletionProposalRec proposal) {
		super(proposal);
	}

	@Override
	public int getRelevance() {
		// TODO : compute relevance switch type?
		return JSDTTernCompletionCollector.TERN_RELEVANT;
	}
	
	@Override
	public IInformationControlCreator getInformationControlCreator() {
		Shell shell = getActiveWorkbenchShell();
		if (shell == null || !BrowserInformationControl.isAvailable(shell))
			return null;

		if (ternControlCreator == null) {
			TernHover h = new TernHover();
			ternControlCreator = h.getHoverControlCreator();
		}
		return ternControlCreator;
	}

}

/**
 *  Copyright (c) 2013-2014 Angelo ZERR.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Angelo Zerr <angelo.zerr@gmail.com> - initial API and implementation
 */
package tern.eclipse.ide.tools.internal.ui;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.osgi.util.NLS;

/**
 * Tern Tools UI messages.
 * 
 */
public final class TernToolsUIMessages extends NLS {

	private static final String BUNDLE_NAME = "tern.eclipse.ide.tools.internal.ui.TernToolsUIMessages"; //$NON-NLS-1$

	private static ResourceBundle fResourceBundle;

	// Buttons
	public static String Button_browse;
	public static String Button_refresh;

	// Wizard
	public static String NewFileWizardPage_name_text;
	public static String NewFileWizardPage_container_text;
	public static String NewFileWizardPage_fileName_text;

	public static String NewTernDefWizard_windowTitle;
	public static String NewTernDefWizardPage_title;
	public static String NewTernDefWizardPage_description;
	public static String NewTernDefWizard_taskLabel;

	public static String NewTernPluginWizard_windowTitle;
	public static String NewTernPluginWizardPage_title;
	public static String NewTernPluginWizardPage_description;
	public static String NewTernPluginWizard_taskLabel;

	public static String TernModulesSelectionWizardPage_title;
	public static String TernModulesSelectionWizardPage_description;
	public static String NewCodeMirrorWizard_windowTitle;
	public static String NewCodeMirrorWizard_taskLabel;
	public static String NewCodeMirrorWizardPage_title;
	public static String NewCodeMirrorWizardPage_description;
	public static String NewAceWizard_windowTitle;
	public static String NewAceWizard_taskLabel;
	public static String NewAceWizardPage_title;
	public static String NewAceWizardPage_description;
	public static String NewOrionWizard_windowTitle;
	public static String NewOrionWizard_taskLabel;
	public static String NewOrionWizardPage_title;
	public static String NewOrionWizardPage_description;
	public static String TernDefsSelectionWizardPage_defLoader_text;
	public static String TernDefsSelectionWizardPage_defLoader_withAjax;
	public static String TernDefsSelectionWizardPage_defLoader_embedInHTML;
	public static String TernDefsSelectionWizardPage_defLoader_embedInJS;

	public static String DownloadTernModulesWizard_taskLabel;
	public static String DownloadTernModulesSelectionWizardPage_title;
	public static String DownloadTernModulesSelectionWizardPage_repositoryURL_text;
	public static String DownloadTernModulesSelectionWizardPage_localRespositoryName_text;
	public static String DownloadTernModulesSelectionWizardPage_description;
	public static String DownloadTernModulesSelectionWizardPage_errorMessage;
	public static String DownloadTernModulesSelectionWizardPage_errorTitle;
	public static String DownloadTernModulesSelectionWizardPage_modules_selection_validation;
	public static String RefreshRepositoryJob_name;
	public static String RefreshRepositoryJob_loading;

	private TernToolsUIMessages() {
	}

	public static ResourceBundle getResourceBundle() {
		try {
			if (fResourceBundle == null)
				fResourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
		} catch (MissingResourceException x) {
			fResourceBundle = null;
		}
		return fResourceBundle;
	}

	static {
		NLS.initializeMessages(BUNDLE_NAME, TernToolsUIMessages.class);
	}
}
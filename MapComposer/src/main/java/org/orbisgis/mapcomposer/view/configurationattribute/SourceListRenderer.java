/*
* MapComposer is an OrbisGIS plugin dedicated to the creation of cartographic
* documents based on OrbisGIS results.
*
* This plugin is developed at French IRSTV institute as part of the MApUCE project,
* funded by the French Agence Nationale de la Recherche (ANR) under contract ANR-13-VBDU-0004.
*
* The MapComposer plugin is distributed under GPL 3 license. It is produced by the "Atelier SIG"
* team of the IRSTV Institute <http://www.irstv.fr/> CNRS FR 2488.
*
* Copyright (C) 2007-2014 IRSTV (FR CNRS 2488)
*
* This file is part of the MapComposer plugin.
*
* The MapComposer plugin is free software: you can redistribute it and/or modify it under the
* terms of the GNU General Public License as published by the Free Software
* Foundation, either version 3 of the License, or (at your option) any later
* version.
*
* The MapComposer plugin is distributed in the hope that it will be useful, but WITHOUT ANY
* WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
* A PARTICULAR PURPOSE. See the GNU General Public License for more details <http://www.gnu.org/licenses/>.
*/

package org.orbisgis.mapcomposer.view.configurationattribute;

import org.orbisgis.mapcomposer.model.configurationattribute.interfaces.ConfigurationAttribute;
import org.orbisgis.mapcomposer.model.configurationattribute.attribute.SourceListCA;
import org.xnap.commons.i18n.I18n;
import org.xnap.commons.i18n.I18nFactory;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import javax.swing.*;

/**
 * Renderer associated to the SourceListCA ConfigurationAttribute.
 * The JPanel returned by the createJComponentFromCA method look like :
 *  ____________________________
 * |selected value          | v |
 * |________________________|___|
 *
 * @see org.orbisgis.mapcomposer.model.configurationattribute.attribute.SourceListCA
 *
 * @author Sylvain PALOMINOS
 */
public class SourceListRenderer implements CARenderer{

    /** Translation*/
    private static final I18n i18n = I18nFactory.getI18n(SourceListRenderer.class);

    @Override
    public JComponent createJComponentFromCA(ConfigurationAttribute ca) {
        SourceListCA sourceListCA = (SourceListCA)ca;

        JComboBox<String> jcb = new JComboBox();
        for(Object o : sourceListCA.getValue()){
            jcb.addItem(i18n.tr(o.toString()));
        }
        jcb.addActionListener(EventHandler.create(ActionListener.class, sourceListCA, "select", "source.selectedItem"));
        //Display the SourceListCA into a JComboBox
        jcb.setSelectedItem(sourceListCA.getSelected());
        
        return jcb;
    }
}

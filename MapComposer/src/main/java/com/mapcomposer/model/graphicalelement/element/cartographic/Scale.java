package com.mapcomposer.model.graphicalelement.element.cartographic;

import com.mapcomposer.model.configurationattribute.ConfigurationAttribute;
import com.mapcomposer.model.graphicalelement.utils.GERefresh;
import java.awt.image.BufferedImage;
import java.util.List;
import org.orbisgis.coremap.map.MapTransform;
import org.orbisgis.progress.NullProgressMonitor;

/**
 * Scale of the map. 
 */
public class Scale extends CartographicElement implements GERefresh{
    
    private MapTransform mapTransform;

    public Scale() {
        super();
        mapTransform = new MapTransform();
    }
    
    @Override
    public List<ConfigurationAttribute> getAllAttributes() {
        return super.getAllAttributes();
    }

    @Override
    public void refresh() {
        mapTransform.setExtent(this.getOwsMapContext().getBoundingBox());
        BufferedImage outImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        mapTransform.setImage(outImage);
        this.getOwsMapContext().draw(mapTransform, new NullProgressMonitor());
    }
    
    public double getMapScale(){
        return mapTransform.getScaleDenominator();
    }
}

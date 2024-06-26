/*
 * Copyright 2013 by TalkingTrends (Amsterdam, The Netherlands)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://opensahara.com/licenses/apache-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.useekm.types;

import com.useekm.types.exception.InvalidGeometryException;
import org.eclipse.rdf4j.model.IRI;
import org.locationtech.jts.geom.Geometry;

public abstract class AbstractGeoSerializer {
    public abstract String toLiteral(Geometry geometry);

    public abstract Geometry toGeometry(String value) throws InvalidGeometryException;

    public abstract AbstractGeo toGeo(String value);

    public abstract IRI getDatatype();

    public abstract Class<? extends AbstractGeo> getGeoClass();
    
    /**
     * @return The value for an empty geometry
     */
    public String empty() {
        return "";
    }
}
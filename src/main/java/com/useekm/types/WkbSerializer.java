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

import com.useekm.indexing.GeoConstants;
import com.useekm.types.exception.InvalidGeometryException;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKBWriter;
import org.apache.commons.codec.binary.Base64;
import org.eclipse.rdf4j.model.IRI;

public final class WkbSerializer extends AbstractGeoSerializer {
    public static final WkbSerializer INTANCE = new WkbSerializer();

    private WkbSerializer() {}

    @Override public String toLiteral(Geometry geometry) {
        return new String(Base64.encodeBase64(new WKBWriter().write(geometry)));
    }

    @Override public Geometry toGeometry(String value) throws InvalidGeometryException {
        return value.isEmpty() ? GeoConvert.getEmptyGeometry() : AbstractGeo.binaryToGeometry(Base64.decodeBase64(value.getBytes()));
    }

    @Override public AbstractGeo toGeo(String value) {
        return new GeoWkb(value);
    }

    @Override public IRI getDatatype() {
        return GeoConstants.XMLSCHEMA_SPATIAL_BIN;
    }

    @Override public Class<? extends AbstractGeo> getGeoClass() {
        return GeoWkb.class;
    }
}

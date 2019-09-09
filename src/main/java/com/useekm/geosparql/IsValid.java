/*
 * Copyright 2011 by TalkingTrends (Amsterdam, The Netherlands)
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
package com.useekm.geosparql;

import com.useekm.indexing.GeoConstants;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.operation.valid.IsValidOp;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;

/**
 * Tests whether a geometry is valid. See http://postgis.net/docs/manual-2.0/using_postgis_dbmanagement.html#OGC_Validity for some background information about isValid (and the
 * difference with isSimple).
 * 
 * @see IsValidOp
 */
public class IsValid extends AbstractBooleanUnaryFunction {
    @Override public String getURI() {
        return GeoConstants.EXT_IS_VALID.stringValue();
    }

    @Override protected boolean accept(ValueFactory valueFactory, Geometry geom, Value... allArgs) {
        return geom.isValid();
    }
}
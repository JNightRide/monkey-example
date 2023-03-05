/*
 * Copyright 2023 wil.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.monkey.example;

import com.jme3.export.InputCapsule;
import com.jme3.export.JmeExporter;
import com.jme3.export.JmeImporter;
import com.jme3.export.OutputCapsule;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import java.io.IOException;

/**
 * Contro de movimiento cubo.
 */
public class CubeRotControl extends AbstractControl {

    private float angle;
    private Vector3f axi;

    public CubeRotControl() {
        this(Vector3f.UNIT_XYZ);
    }

    public CubeRotControl(Vector3f axi) {
        this.axi = axi;
    }

    @Override
    public void setSpatial(Spatial spatial) {
        if (!(spatial instanceof Geometry)) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        super.setSpatial(spatial);
    }

    @Override
    protected void controlUpdate(float tpf) {
        angle = FastMath.PI * tpf;
        spatial.rotate(new Quaternion().fromAngleAxis(angle, axi));
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        // TODO: El control de renderizado.
    }

    @Override
    public void write(JmeExporter ex) throws IOException {
        super.write(ex); 
        
        OutputCapsule out = ex.getCapsule(this);
        out.write(axi, "axi", null);
    }

    @Override
    public void read(JmeImporter im) throws IOException {
        super.read(im);
        
        InputCapsule in = im.getCapsule(this);
        axi = (Vector3f) in.readSavable("axi", axi);
    }
}

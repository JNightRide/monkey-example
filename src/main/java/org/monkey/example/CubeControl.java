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

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

/**
 * Control del cubo.
 */
public final class CubeControl extends AbstractControl {

    private float time;
    private ColorRGBA actColorRGBA;
    private ColorRGBA desColorRGBA;

    public CubeControl() {
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
        if (desColorRGBA == null) {
            desColorRGBA = ColorRGBA.randomColor();
        }
        
        time += tpf * 100.0f;
        if (time >= 100) {
            desColorRGBA = ColorRGBA.randomColor();
            time = 0;
        }

        Geometry g = (Geometry) spatial;
        Material mat = g.getMaterial();

        actColorRGBA = mat.getParamValue("Color");
        mat.setColor("Color", actColorRGBA.interpolateLocal(desColorRGBA, tpf));
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        // TODO: El control de renderizado.
    }
}

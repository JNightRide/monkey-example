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

import com.jme3.app.SimpleApplication;
import com.jme3.scene.Geometry;
import com.jme3.system.JmeSystem;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.monkey.export.json.JsonImporter;

/**
 * Clase que ejemplifica la importacion de un objeto {@code Savable} con
 * {@code JsonImporter}. Se carga un cubo con un control incoporado en donde
 * cambia de color durante cierto tiempo.
 */
public class Cube extends SimpleApplication {

    public static void main(String[] args) {
        Cube app = new Cube();        
        app.setShowSettings(false);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        Geometry geom = null;

        JsonImporter importer = JsonImporter.getInstance();
        importer.setAssetManager(assetManager);

        try {
            geom = (Geometry) importer.load(JmeSystem.getResource("/Model/Cube.j3o.json"));
        } catch (IOException ex) {
            Logger.getLogger(Cube.class.getName()).log(Level.SEVERE, null, ex);
        }

        rootNode.attachChild(geom);
    }
}

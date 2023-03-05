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
import com.jme3.scene.Node;
import com.jme3.system.JmeSystem;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.monkey.export.json.JsonImporter;

/**
 * Clase que ejemplifica el cargado o importacion de una ecena({@code Node})
 * en formtato {@code JSON}.
 */
public class Boxs extends SimpleApplication {
    
    public static void main(String[] args) {
        Boxs app = new Boxs();
        app.start();
    }

    @Override
    public void simpleInitApp() {        
        Node boxes = null;
        JsonImporter importer = JsonImporter.getInstance();
        importer.setAssetManager(assetManager);
        
        try {
            boxes = (Node) importer.load(JmeSystem.getResource("/Model/Boxes.j3o.json"));
        } catch (IOException ex) {
            Logger.getLogger(Boxs.class.getName()).log(Level.SEVERE, null, ex);
        }

        rootNode.attachChild(boxes);
        
    }
}

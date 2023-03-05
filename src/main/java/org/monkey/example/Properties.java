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
import com.jme3.system.JmeSystem;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.monkey.JmeProperties;
import org.monkey.export.json.JsonImporter;

/**
 * Ejemplo de importacion de un objeto de propiedades con
 * monkey.
 */
public class Properties extends SimpleApplication {
    
    public static void main(String[] args) {
        Properties app = new Properties();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        JmeProperties jp = null;
        JsonImporter importer = JsonImporter.getInstance();
        
        try {
            jp = (JmeProperties) importer.load(JmeSystem.getResource("/Model/Properties.jp3.json"));
        } catch (IOException ex) {
            Logger.getLogger(Properties.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (jp != null) {
            System.out.println(jp.toString(1));
        } else {
            System.out.println("null");
        }
    }
}

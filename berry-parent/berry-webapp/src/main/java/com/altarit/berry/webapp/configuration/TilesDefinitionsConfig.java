package com.altarit.berry.webapp.configuration;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.request.Request;

import java.util.HashMap;
import java.util.Map;

public class TilesDefinitionsConfig implements DefinitionsFactory {

    private static final Map<String, Definition> tilesDefinitions = new HashMap<String,Definition>();
    private static final Attribute BASE_TEMPLATE = new Attribute("/WEB-INF/views/_layout/defaultLayout.jsp");

    @Override
    public Definition getDefinition(String name, Request tilesContext) {
        return tilesDefinitions.get(name);
    }

    private static void addDefaultLayoutDef(String name, String title, String body) {
        Map<String, Attribute> attributes = new HashMap<String,Attribute>();

        attributes.put("title", new Attribute(title));
        attributes.put("header", new Attribute("/WEB-INF/views/_layout/header.jsp"));
        attributes.put("sidebar", new Attribute("/WEB-INF/views/_layout/sidebar.jsp"));
        //attributes.put("menu", new Attribute("/WEB-INF/views/layout/menu.jsp"));
        attributes.put("body", new Attribute(body));
        attributes.put("footer", new Attribute("/WEB-INF/views/_layout/footer.jsp"));

        tilesDefinitions.put(name, new Definition(name, BASE_TEMPLATE, attributes));
    }

    public static void addDefinitions(){
        addDefaultLayoutDef("home", "Home", "/WEB-INF/views/home.jsp");
        addDefaultLayoutDef("index", "Index", "/WEB-INF/views/index.jsp");
        addDefaultLayoutDef("users/index", "Users", "/WEB-INF/views/users/index.jsp");
        addDefaultLayoutDef("users/registration", "Registration", "/WEB-INF/views/users/registration.jsp");
        addDefaultLayoutDef("users/deletion", "Deletion", "/WEB-INF/views/users/deletion.jsp");
        addDefaultLayoutDef("users/login", "Login", "/WEB-INF/views/users/login.jsp");
        addDefaultLayoutDef("blog/posts", "Posts", "/WEB-INF/views/blog/index.jsp");
        addDefaultLayoutDef("blog/editor", "Editor", "/WEB-INF/views/blog/editor.jsp");
        addDefaultLayoutDef("blog/details", "Details", "/WEB-INF/views/blog/details.jsp");
    }
}

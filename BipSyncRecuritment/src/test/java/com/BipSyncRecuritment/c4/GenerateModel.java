package com.BipSyncRecuritment.c4;

import com.structurizr.Workspace;
import com.structurizr.analysis.ComponentFinder;
import com.structurizr.analysis.ReferencedTypesSupportingTypesStrategy;
import com.structurizr.analysis.SpringComponentFinderStrategy;
import com.structurizr.analysis.StructurizrAnnotationsComponentFinderStrategy;
import com.structurizr.api.StructurizrClient;
import com.structurizr.model.*;
import com.structurizr.view.*;
import org.junit.jupiter.api.Test;

public class GenerateModel {

    private final static int WORKSPACE_ID = 8731;
    private final static String API_KEY = "045eb293-5bac-4c17-8213-8ef1e101ed8a";
    private final static String API_SECRET = "23398d8c-1ca0-464b-8a0f-04b1eadd47f7";

    @Test
    public void generateModel() throws Exception {
        Workspace workspace = new Workspace("Bipsync Client Project", "Onboarding Checklist for Bipsync using springboot 2023");
        Model model = workspace.getModel();


        SoftwareSystem bipsyncClientProject = model.addSoftwareSystem("Bipsync Client Project", "Onboarding Checklist for Bipsync");
        Person admin = model.addPerson("Admin for Website", "  A person who has access to everything on the website.");
        Person staff = model.addPerson("Staff", "  A person who is in charge of completing specific tasks needed for the onboarding process");

        admin.uses(bipsyncClientProject, "Uses");
        staff.uses(bipsyncClientProject, "Uses");

        Container webApplication = bipsyncClientProject.addContainer(
                "Spring Boot Application", "The web application", "Embedded web container.  Tomcat 7.0");
        Container relationalDatabase = bipsyncClientProject.addContainer(
                "Relational Database", "Stores information regarding the products.", "MySQL");
        admin.uses(webApplication, "Uses", "HTTP");
        staff.uses(webApplication, "Uses", "HTTP");

        webApplication.uses(relationalDatabase, "Reads from and writes to", "JPA, port 3306");

        //and now automatically find all Spring @Controller, @Component, @Service and @Repository components
        ComponentFinder componentFinder = new ComponentFinder(
                webApplication,
                "com.BipSyncRecuritment",
                new SpringComponentFinderStrategy(
                        new ReferencedTypesSupportingTypesStrategy()
                ));
        componentFinder.findComponents();

        ComponentFinder componentFinderByAnnotation = new ComponentFinder(
                webApplication,
                "com.BipSyncRecuritment",
                new StructurizrAnnotationsComponentFinderStrategy()
        );
        componentFinderByAnnotation.findComponents();


// connect the user to all the Spring MVC controllers
        webApplication.getComponents().stream()
                .filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER))
                .forEach(c -> admin.uses(c, "Uses", "HTTP"));



        //connect the registration system to all the Spring MVC controllers
        webApplication.getComponents().stream()
                .filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_REPOSITORY))
                .forEach(c -> c.uses(relationalDatabase, "Reads from and writes to", "JPA"));



        for (Component c : webApplication.getComponents()) {
            System.out.println(c.getRelationships());
        }
        //Debugging code - check things are being set correctly.

                Component cservice = webApplication.getComponentOfType("com.BipSyncRecuritment.services.UserService");

        System.out.println(cservice);

        Component cRepo = webApplication.getComponentOfType("com.BipSyncRecuritment.repositories.UserRepositoryJPA");
        System.out.println(cRepo);

        cservice.uses(cRepo, "uses");

        //create views
        ViewSet viewSet = workspace.getViews();
        SystemContextView contextView = viewSet.createSystemContextView(bipsyncClientProject, "context", "The System Context diagram for the  Bipsync Client Project.");
        contextView.addAllSoftwareSystems();
        contextView.addAllPeople();
        contextView.enableAutomaticLayout();

        ContainerView containerView = viewSet.createContainerView(bipsyncClientProject, "containers", "The Containers diagram for the  Bipsync Client Project.");
        containerView.addAllPeople();
        containerView.addAllSoftwareSystems();
        containerView.addAllContainers();
        containerView.enableAutomaticLayout();


        ComponentView componentView = viewSet.createComponentView(webApplication, "components", "The Components diagram for  the Bipsync Client Project.");
        componentView.addAllComponents();
        componentView.addAllPeople();
        componentView.add(relationalDatabase);
        componentView.enableAutomaticLayout();
        for (Component component : webApplication.getComponents()) {
            for (CodeElement codeElement : component.getCode()) {
                String sourcePath = codeElement.getUrl();
                if (sourcePath != null) {
                    codeElement.setUrl(
                            "https://git.cardiff.ac.uk/c22067777/projectclient_y2s1_bipsync_10/-/tree/main");
                }
            }
        }


        //tag and style some elements

        bipsyncClientProject.addTags("Bipsync Client Project 2023");
        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER)).forEach(c -> c.addTags("Spring MVC Controller"));
        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER)).forEach(c -> c.addTags("Spring REST Controller"));

        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_SERVICE)).forEach(c -> c.addTags("Spring Service"));
        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_REPOSITORY)).forEach(c -> c.addTags("Spring Repository"));
        relationalDatabase.addTags("Database");


        Styles styles = viewSet.getConfiguration().getStyles();
        styles.addElementStyle("Bipsync Client Project 2023").background("#6CB33E").color("#ffffff");
        styles.addElementStyle(Tags.PERSON).background("#519823").color("#ffffff").shape(Shape.Person);
        styles.addElementStyle(Tags.CONTAINER).background("#91D366").color("#ffffff");
        styles.addElementStyle("Database").shape(Shape.Cylinder);

        styles.addElementStyle("Spring REST Controller").background("#D4FFC0").color("#000000");

        styles.addElementStyle("Spring MVC Controller").background("#D4F3C0").color("#000000");
        styles.addElementStyle("Spring Service").background("#6CB33E").color("#000000");
        styles.addElementStyle("Spring Repository").background("#95D46C").color("#000000");


        //System.setProperty("jdk.tls.client.protocols","TLSv1,TLSv1.1,TLSv1.2");


        StructurizrClient structurizrClient = new StructurizrClient(API_KEY, API_SECRET);
        structurizrClient.putWorkspace(WORKSPACE_ID, workspace);
    }
}
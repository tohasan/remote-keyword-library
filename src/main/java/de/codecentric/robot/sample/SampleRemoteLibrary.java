package de.codecentric.robot.sample;

import org.robotframework.javalib.library.AnnotationLibrary;
import org.robotframework.remoteserver.RemoteServer;

public class SampleRemoteLibrary extends AnnotationLibrary {

    public SampleRemoteLibrary() {
        super("de/codecentric/robot/sample/keywords/*.class");
    }

    @Override
    public String getKeywordDocumentation(String keywordName) {
        if (keywordName.equals("__intro__")) {
            return "Intro";
        }

        return super.getKeywordDocumentation(keywordName);
    }

    public static void main(String[] args) throws Exception {
        RemoteServer.configureLogging();
        RemoteServer server = new RemoteServer();
        server.addLibrary(SampleRemoteLibrary.class, 8270);
        server.start();
    }
}


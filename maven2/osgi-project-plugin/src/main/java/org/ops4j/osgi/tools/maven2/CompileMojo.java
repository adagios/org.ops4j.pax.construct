package org.ops4j.osgi.tools.maven2;

/*
 * Copyright 2007 Stuart McCulloch
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

import org.apache.maven.plugin.MojoExecutionException;
import org.codehaus.plexus.util.cli.Commandline;

/**
 * Goal which adds an compiled bundle to an existing OSGi project.
 *
 * @goal compile
 */
public class CompileMojo
    extends AbstractArchetypeMojo
{
    /**
     * The groupId of the bundle to compile.
     * 
     * @parameter expression="${groupId}"
     * @required
     */
    private String groupId;

    /**
     * The artifactId of the bundle to compile.
     * 
     * @parameter expression="${artifactId}"
     * @required
     */
    private String artifactId;

    /**
     * The version of the bundle to compile.
     * 
     * @parameter expression="${version}"
     * @required
     */
    private String version;

    protected boolean checkEnvironment()
        throws MojoExecutionException
    {
        return project.getArtifactId().equals("compile-bundle");
    }

    protected void createSubArguments( Commandline commandLine )
    {
        commandLine.createArgument().setValue( "-DarchetypeArtifactId=compile-bundle-archetype" );

        commandLine.createArgument().setValue( "-DgroupId="+project.getGroupId() );

        commandLine.createArgument().setValue( "-DpackageName="+groupId );
        commandLine.createArgument().setValue( "-DartifactId="+artifactId );
        commandLine.createArgument().setValue( "-Dversion="+version );

        commandLine.createArgument().setValue( "-Duser.dir="+project.getBasedir() );
    }
}


package org.ops4j.pax.construct.clone;

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

/**
 * Builder interface for a Pax-Construct command
 */
public interface PaxCommandBuilder
{
    /**
     * Add a simple flag to the command, such as -x
     * 
     * @param flag the flag character
     * @return builder for the Pax-Construct command
     */
    PaxCommandBuilder flag( char flag );

    /**
     * Add an option setting to the command, such as -y value
     * 
     * @param option the option character
     * @param value the value to use
     * @return builder for the Pax-Construct command
     */
    PaxCommandBuilder option( char option, String value );

    /**
     * Add Maven specific options using the given builder
     * 
     * @return builder for Maven specific options
     */
    MavenOptionBuilder maven();
}

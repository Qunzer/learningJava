/**
 * Created by renqun.yuan on 2015/10/14.
 */
package com.javalearning.singleton;

/**
 * Reference:
 * http://www.programcreek.com/2011/07/java-design-pattern-singleton/
 * http://coolshell.cn/articles/265.html
 * <p/>
 * Here is a simple use case. A country can have only one president
 * <p/>
 * Singleton Pattern
 * it should satisfy:
 * 1. private constructor - no other class can instantiate a new object.
 * 2.private reference - no external modification.
 * 3.public static method is the only place that can get an object.
 * <p/>
 * There are two modes:
 * 1. Eager Mode
 * 2. Lazy Mode
 * <p/>
 * Runtime.getRuntime() is singleton in Java
 * see: java.lang.Runtime
 **/


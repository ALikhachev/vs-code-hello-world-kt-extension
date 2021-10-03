@file:JsModule("vscode")
@file:JsNonModule
@file:JsQualifier("extensions")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package vscode.extensions

import kotlin.js.*
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*
import vscode.Extension
import vscode.Event

external fun getExtension(extensionId: String): Extension<Any>?

external fun <T> getExtension(extensionId: String): Extension<T>?

external var all: Array<Extension<Any>>

external var onDidChange: Event<Unit>
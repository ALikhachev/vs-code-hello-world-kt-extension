@file:JsModule("vscode")
@file:JsNonModule
@file:JsQualifier("authentication")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package vscode.authentication

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
import vscode.AuthenticationGetSessionOptions
import Thenable
import vscode.AuthenticationSession
import vscode.Event
import vscode.AuthenticationSessionsChangeEvent
import vscode.AuthenticationProvider
import vscode.AuthenticationProviderOptions
import vscode.Disposable

external interface `T$54` {
    var createIfNone: Boolean
}

external fun getSession(providerId: String, scopes: Array<String>, options: AuthenticationGetSessionOptions /* AuthenticationGetSessionOptions & `T$54` */): dynamic /* Thenable | Thenable */

external fun getSession(providerId: String, scopes: Array<String>): Thenable<AuthenticationSession?>

external var onDidChangeSessions: Event<AuthenticationSessionsChangeEvent>

external fun registerAuthenticationProvider(id: String, label: String, provider: AuthenticationProvider, options: AuthenticationProviderOptions = definedExternally): Disposable
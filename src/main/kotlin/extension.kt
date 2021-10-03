@JsExport
fun activate(context: vscode.ExtensionContext) {
    val disposable = vscode.commands.registerCommand("helloworld.helloWorld", {
        vscode.window.showInformationMessage("Hello World from Kotlin/JS!")
    })

    context.subscriptions.asDynamic().push(disposable)
}

@JsExport
fun deactivate() {

}
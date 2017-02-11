<p>Macros</p>

<#-- Override macro -->

<#macro specialMacro param="defaultValue">
	Param ${param}
</#macro>

<span>Calling original macro: <@specialMacro param="Yeah!"/></span><br/>

<#macro specialMacro param="newDefaultValue">
	Your param - ${param}
</#macro>

<span>Calling overriden macro: <@specialMacro param="Yeah!"/></span><br/>



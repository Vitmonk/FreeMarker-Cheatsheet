
<p>Enums</p>
<#-- Enums are converted to maps! Keys are names and values are the enum constants! -->
<span>Full enum: {
	<#list MyEnum as key, constant>
		${constant} - ${constant.number}<#sep>, </#sep>
	</#list>}
</span><br/>
<span>Specific constant: ${MyEnum.FIRST}</span><br/>
<span>Specific constant number: ${MyEnum.FIRST.getNumber()}</span><br/>
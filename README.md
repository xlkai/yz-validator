# yz-validator
Java版本、通过注解方式进行数据的校验。<br><hr>
<b>校验内容（支持的数据类型）</b>：空值（所有对象）、长度（基本类型、Collection、Map）、小数位数（Float、Double）、正则校验（字符串）、以及自定义校验规则（所有对象）<br><br>
<b>校验注解</b>：@Valids、@Valid<br>
<b>@Valids</b>:<br>
name：字段简称。用于校验失败提示消息；<br>
value：校验规则。数组类型，一个字段支持多个不同的校验规则，用@valid的id属性进行标识；<br><br>
<b>@Valid</b>:<br>
name：字段简称。用于校验失败提示消息；<br>
id：校验规则标识。一般情况下一个JavaBean分多次校验场景，在不同的场景下面的校验规则也不一样，为每个场景定义一个标识id，校验时直接指定标识id即可；<br>
nullable：是否为空，默认false。false时进行非空校验；<br>
min：最小长度。String、Number、Collection、Map最小长度；<br>
max：最大长度，默认Integer.MAX_VALUE。String、Number、Collection、Map最大长度；<br>
scale：小数精度。数据类型为Float、Double时进行校验；<br>
pattern：正则表达式；<br>
patternMsg：正则表达式校验失败时的提示消息，支持变量name替换（#{name}）；<br>
custom：自定义校验规则Class。<br>
<hr>
<b>调用方式：</b><br>
1. ValidManager.valid(Object object)；
2. ValidManager.valid(Object object, String id)；
3. ValidManager.valid(ValidProvider provider, Object object, String id)；

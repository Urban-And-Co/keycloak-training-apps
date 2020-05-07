# keycloak-login-recaptcha

By default Keycloak only supports ReCaptcha for Regsitration, not login. so we created a simple module for activating recaptcha for login

#		How to use
for building you need to run

````
  mvn clean spring-javaformat:apply install
````

It will produce a jar `target/recaptcha-login.jar`.

To deploy the provider, run the following maven command:
                                         
````
  mvn clean spring-javaformat:apply install wildfly:deploy
````

In your theme file you should add this piece of code in your `login.ftl` template file:
```
<#if recaptchaRequired??>
<div class="form-group">
	<div class="${properties.kcInputWrapperClass!}">
		<div class="g-recaptcha" data-size="compact" data-sitekey="${recaptchaSiteKey}">			
		</div>
	</div>
</div>
</#if>
```
you should past it inside your login `<form></form>` in your login template (`login.ftl`)

And finally you should enable external origin `https://google.com` like the way in keycloaks'  [Recaptcha Documentation](https://www.keycloak.org/docs/latest/server_admin/index.html#_recaptcha) mentioned.

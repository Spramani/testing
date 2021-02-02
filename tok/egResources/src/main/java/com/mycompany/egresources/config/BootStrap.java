package com.mycompany.egresources.config;
import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import org.eclipse.microprofile.auth.LoginConfig;

@SuppressWarnings({"EmptyClass", "SuppressionAnnotation"})
@ApplicationPath("rest")
@DeclareRoles({"Admin","User"})
@LoginConfig(authMethod = "MP-JWT")
public class BootStrap extends javax.ws.rs.core.Application {
}

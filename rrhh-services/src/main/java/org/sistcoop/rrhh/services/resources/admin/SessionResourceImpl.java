package org.sistcoop.rrhh.services.resources.admin;

import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;

import org.jboss.resteasy.spi.HttpRequest;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.sistcoop.rrhh.admin.client.resource.SessionResource;
import org.sistcoop.rrhh.models.AgenciaModel;
import org.sistcoop.rrhh.models.SucursalModel;
import org.sistcoop.rrhh.models.TrabajadorModel;
import org.sistcoop.rrhh.models.TrabajadorUsuarioModel;
import org.sistcoop.rrhh.models.TrabajadorUsuarioProvider;
import org.sistcoop.rrhh.models.utils.ModelToRepresentation;
import org.sistcoop.rrhh.representations.idm.AgenciaRepresentation;
import org.sistcoop.rrhh.representations.idm.SucursalRepresentation;
import org.sistcoop.rrhh.representations.idm.TrabajadorRepresentation;

@Stateless
public class SessionResourceImpl implements SessionResource {

    @Context
    private HttpRequest httpRequest;

    @Inject
    private TrabajadorUsuarioProvider trabajadorUsuarioProvider;

    @Override
    public SucursalRepresentation getSucursal() {
        // Just to show how to user info from access token in REST endpoint
        KeycloakSecurityContext securityContext = (KeycloakSecurityContext) httpRequest
                .getAttribute(KeycloakSecurityContext.class.getName());
        AccessToken accessToken = securityContext.getToken();

        // Obtener Usuario
        Set<String> roles = accessToken.getRealmAccess().getRoles();
        String usuario = accessToken.getPreferredUsername();

        TrabajadorUsuarioModel trabajadorUsuarioModel = trabajadorUsuarioProvider.findByUsuario(usuario);
        if (roles.contains("ADMIN")) {
            if (trabajadorUsuarioModel == null) {
                return null;
            }
        } else {
            if (trabajadorUsuarioModel == null) {
                throw new BadRequestException("Usuario no encontrado en RRHH");
            }
        }

        // Verificar
        TrabajadorModel trabajadorModel = trabajadorUsuarioModel.getTrabajador();
        AgenciaModel agenciaModel = trabajadorModel.getAgencia();
        SucursalModel sucursalModel = agenciaModel.getSucursal();

        SucursalRepresentation rep = ModelToRepresentation.toRepresentation(sucursalModel);
        if (rep != null) {
            return rep;
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public AgenciaRepresentation getAgencia() {
        // Just to show how to user info from access token in REST endpoint
        KeycloakSecurityContext securityContext = (KeycloakSecurityContext) httpRequest
                .getAttribute(KeycloakSecurityContext.class.getName());
        AccessToken accessToken = securityContext.getToken();

        // Obtener Usuario
        Set<String> roles = accessToken.getRealmAccess().getRoles();
        String usuario = accessToken.getPreferredUsername();

        TrabajadorUsuarioModel trabajadorUsuarioModel = trabajadorUsuarioProvider.findByUsuario(usuario);
        if (roles.contains("ADMIN")) {
            if (trabajadorUsuarioModel == null) {
                return null;
            }
        } else {
            if (trabajadorUsuarioModel == null) {
                throw new BadRequestException("Usuario no encontrado en RRHH");
            }
        }

        // Verificar
        TrabajadorModel trabajadorModel = trabajadorUsuarioModel.getTrabajador();
        AgenciaModel agenciaModel = trabajadorModel.getAgencia();

        AgenciaRepresentation rep = ModelToRepresentation.toRepresentation(agenciaModel);
        if (rep != null) {
            return rep;
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public TrabajadorRepresentation getTrabajador() {
        // Just to show how to user info from access token in REST endpoint
        KeycloakSecurityContext securityContext = (KeycloakSecurityContext) httpRequest
                .getAttribute(KeycloakSecurityContext.class.getName());
        AccessToken accessToken = securityContext.getToken();

        // Obtener Usuario
        Set<String> roles = accessToken.getRealmAccess().getRoles();
        String usuario = accessToken.getPreferredUsername();

        TrabajadorUsuarioModel trabajadorUsuarioModel = trabajadorUsuarioProvider.findByUsuario(usuario);
        if (roles.contains("ADMIN")) {
            if (trabajadorUsuarioModel == null) {
                return null;
            }
        } else {
            if (trabajadorUsuarioModel == null) {
                throw new BadRequestException("Usuario no encontrado en RRHH");
            }
        }

        // Verificar
        TrabajadorModel trabajadorModel = trabajadorUsuarioModel.getTrabajador();

        TrabajadorRepresentation rep = ModelToRepresentation.toRepresentation(trabajadorModel);
        if (rep != null) {
            return rep;
        } else {
            throw new NotFoundException();
        }
    }

}

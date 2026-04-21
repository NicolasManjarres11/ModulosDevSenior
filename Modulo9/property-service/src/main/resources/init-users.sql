-- Script de inicialización de usuarios (ejecutar manualmente cuando sea necesario)
-- Este script se puede ejecutar en DBeaver o cualquier cliente SQL
-- NOTA: Las contraseñas están encriptadas con BCrypt

-- Insertar usuario de prueba para autenticación (password: admin123)
INSERT INTO usuarios (username, password, email, full_name, is_active) 
VALUES ('admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVEFDa', 'admin@example.com', 'Administrador del Sistema', true)
ON CONFLICT (username) DO NOTHING;

-- Insertar usuarios adicionales de ejemplo (password: password123)
INSERT INTO usuarios (username, password, email, full_name, is_active) 
VALUES 
    ('usuario1', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVEFDa', 'usuario1@example.com', 'Usuario Ejemplo 1', true),
    ('usuario2', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVEFDa', 'usuario2@example.com', 'Usuario Ejemplo 2', true),
    ('test', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVEFDa', 'test@example.com', 'Usuario de Prueba', true)
ON CONFLICT (username) DO NOTHING;

-- Verificar que se insertaron los usuarios
SELECT COUNT(*) as total_usuarios FROM usuarios;

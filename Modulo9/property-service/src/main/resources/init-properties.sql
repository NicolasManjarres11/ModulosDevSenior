-- Script de inicialización de propiedades (ejecutar manualmente cuando sea necesario)
-- Este script se puede ejecutar en DBeaver o cualquier cliente SQL

-- Insertar propiedades de ejemplo
INSERT INTO propiedades (address, city, price, bedrooms, bathrooms, image_url, description) 
VALUES 
    ('Calle Principal 123', 'Madrid', 250000.00, 3, 2, 'https://example.com/img1.jpg', 'Hermosa casa en el centro de Madrid'),
    ('Avenida del Mar 456', 'Barcelona', 320000.00, 4, 3, 'https://example.com/img2.jpg', 'Apartamento moderno con vista al mar'),
    ('Plaza Mayor 789', 'Valencia', 180000.00, 2, 1, 'https://example.com/img3.jpg', 'Casa tradicional en el casco histórico'),
    ('Calle Gran Vía 321', 'Madrid', 450000.00, 5, 4, 'https://example.com/img4.jpg', 'Mansión de lujo en zona exclusiva'),
    ('Paseo Marítimo 654', 'Málaga', 280000.00, 3, 2, 'https://example.com/img5.jpg', 'Casa de playa con terraza privada')
ON CONFLICT (id) DO NOTHING;

-- Verificar que se insertaron las propiedades
SELECT COUNT(*) as total_propiedades FROM propiedades;

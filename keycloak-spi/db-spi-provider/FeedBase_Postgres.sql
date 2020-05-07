INSERT INTO cerbere.client(id, code, name, description) VALUES ('789249c4-feed-42ed-83f8-5af289fb7b38', 'SECHEL', 'Sechel', 'Sechel');
INSERT INTO cerbere.client(id, code, name, description) VALUES ('4617114e-4b9d-4722-8bc0-fd22f401500e', 'OSMOSE', 'Osmose', 'Osmose');
INSERT INTO cerbere.client(id, code, name, description) VALUES ('8ea0344f-abe2-4d16-976b-f3c0a8be83dc', 'FACE', 'Face', 'Face');
	
INSERT INTO cerbere.actor(id, title, gender, first_name, last_name, username, email, creation_date, address, city, country, postal_code, province, password, phone_number)
 VALUES ('c2a04887-d5cd-4c0a-a676-e1c295a72c2b', 'Mr', 'M', 'Philippe', 'Rouvray', 'phrouv', 'phrouv@lycos.com', current_timestamp, 'Rue du Tertre St-Michel', 'Plerin', 'FR', '22190', 'Bretagne', 'arpad5', '0638444441');
 
INSERT INTO cerbere.cli_role(id, code, name, description, cli_id) VALUES ('648e4935-5ed4-4fd6-b3e1-9ccc3f515789', 'DGECINS', 'DGEC instructeur', 'DGEC instructeur', '789249c4-feed-42ed-83f8-5af289fb7b38');
INSERT INTO cerbere.cli_role(id, code, name, description, cli_id) VALUES ('e6892b44-2f95-452c-bd9c-f9ca4621ed05', 'DGECADM', 'DGEC administrateur général', 'DGEC administrateur général', '789249c4-feed-42ed-83f8-5af289fb7b38');
INSERT INTO cerbere.cli_role(id, code, name, description, cli_id) VALUES ('f932ec42-9ac3-4cf3-9eec-a3449f63bdde', 'DREALINS', 'DREAL instructeur', 'DREAL instructeur', '789249c4-feed-42ed-83f8-5af289fb7b38');
INSERT INTO cerbere.cli_role(id, code, name, description, cli_id) VALUES ('04c52443-7175-4e00-91d0-a72ca9c99d2f', 'DREALADM', 'DREAL administrateur local', 'DREAL administrateur local', '789249c4-feed-42ed-83f8-5af289fb7b38');
INSERT INTO cerbere.cli_role(id, code, name, description, cli_id) VALUES ('daf78641-0967-4df3-a0a2-63c8f330b97b', 'SYSTEM', 'Système', 'Système', '4617114e-4b9d-4722-8bc0-fd22f401500e');
INSERT INTO cerbere.cli_role(id, code, name, description, cli_id) VALUES ('8ca81c0c-5783-4c32-843d-849e692f312b', 'ADMNAT', 'Administrateur national', 'Administrateur national', '4617114e-4b9d-4722-8bc0-fd22f401500e');
INSERT INTO cerbere.cli_role(id, code, name, description, cli_id) VALUES ('b4f3dfa1-ec67-4ae3-b86e-5780aca0a1a7', 'ADMBAS', 'Administrateur bassin', 'Administrateur bassin', '4617114e-4b9d-4722-8bc0-fd22f401500e');
INSERT INTO cerbere.cli_role(id, code, name, description, cli_id) VALUES ('f92e3411-9716-48c5-bf4e-de5094d88047', 'ADMREG', 'Administrateur régional', 'Administrateur régional', '4617114e-4b9d-4722-8bc0-fd22f401500e');
INSERT INTO cerbere.cli_role(id, code, name, description, cli_id) VALUES ('89f77301-0eee-498d-9f1e-d60bc55f3230', 'ADMDEP', 'Administrateur départemental', 'Administrateur départemental', '4617114e-4b9d-4722-8bc0-fd22f401500e');
INSERT INTO cerbere.cli_role(id, code, name, description, cli_id) VALUES ('f83e8d13-2e8f-4a5c-bb00-f1a840930581', 'UTLBAS', 'Utilisateur bassin', 'Utilisateur bassin', '4617114e-4b9d-4722-8bc0-fd22f401500e');
INSERT INTO cerbere.cli_role(id, code, name, description, cli_id) VALUES ('b3a0d227-e587-4644-8465-1f458c68ce50', 'UTLREG', 'Utilisateur régional', 'Utilisateur régional', '4617114e-4b9d-4722-8bc0-fd22f401500e');
INSERT INTO cerbere.cli_role(id, code, name, description, cli_id) VALUES ('01249d3b-4a0a-4ed9-b259-f1f6d7def5ee', 'UTLDEP', 'Utilisateur départemental', 'Utilisateur départemental', '4617114e-4b9d-4722-8bc0-fd22f401500e');
	
INSERT INTO cerbere.actor_role(act_id, rol_id) VALUES ('c2a04887-d5cd-4c0a-a676-e1c295a72c2b', '648e4935-5ed4-4fd6-b3e1-9ccc3f515789');
INSERT INTO cerbere.actor_role(act_id, rol_id) VALUES ('c2a04887-d5cd-4c0a-a676-e1c295a72c2b', '04c52443-7175-4e00-91d0-a72ca9c99d2f');
INSERT INTO cerbere.actor_role(act_id, rol_id) VALUES ('c2a04887-d5cd-4c0a-a676-e1c295a72c2b', '8ca81c0c-5783-4c32-843d-849e692f312b');

INSERT INTO cerbere.geo_group(id, code, name, description, cli_id) VALUES ('a3591813-6a01-45c4-ba8d-b424cf7607aa', 'BRETAGNE', 'DREAL Bretagne', 'DREAL Bretagne', '789249c4-feed-42ed-83f8-5af289fb7b38');
INSERT INTO cerbere.geo_group(id, code, name, description, cli_id) VALUES ('e4d38f58-2f98-4a2a-a3b7-30e8692f0b59', 'GRAND-EST', 'DREAL Grand Est', 'DREAL Grand Est', '789249c4-feed-42ed-83f8-5af289fb7b38');
INSERT INTO cerbere.geo_group(id, code, name, description, cli_id) VALUES ('1f45469b-5e34-4e1f-9455-cb894823d524', 'NVL-AQUIT', 'DREAL Nouvelle-Aquitaine', 'DREAL Nouvelle-Aquitaine', '789249c4-feed-42ed-83f8-5af289fb7b38');
INSERT INTO cerbere.geo_group(id, code, name, description, cli_id) VALUES ('1e36e7e8-8034-4173-979d-67e31912865c', 'AUVERGNE', 'DREAL Auvergne-Rhône-Alpes', 'DREAL Auvergne-Rhône-Alpes', '789249c4-feed-42ed-83f8-5af289fb7b38');
INSERT INTO cerbere.geo_group(id, code, name, description, cli_id) VALUES ('6b71a072-b4cf-41ad-b530-b0b99448a1bb', 'BOURGOGNE', 'DREAL Bourgogne-Franche-Comté', 'DREAL Bourgogne-Franche-Comté', '789249c4-feed-42ed-83f8-5af289fb7b38');
INSERT INTO cerbere.geo_group(id, code, name, description, cli_id) VALUES ('d3d25b60-714b-461e-842b-b548e6e18d98', 'VAL-LOIRE', 'DREAL Centre-Val de Loire', 'DREAL Centre-Val de Loire', '789249c4-feed-42ed-83f8-5af289fb7b38');
INSERT INTO cerbere.geo_group(id, code, name, description, cli_id) VALUES ('e6e8448b-5e1c-488c-b24d-6669359a727e', 'CORSE', 'DREAL Corse', 'DREAL Corse', '789249c4-feed-42ed-83f8-5af289fb7b38');
INSERT INTO cerbere.geo_group(id, code, name, description, cli_id) VALUES ('5ae1147e-0646-4bad-8177-af8c957e7156', 'OCCITANIE', 'DREAL Occitanie', 'DREAL Occitanie', '789249c4-feed-42ed-83f8-5af289fb7b38');
INSERT INTO cerbere.geo_group(id, code, name, description, cli_id) VALUES ('24f5de2b-3532-4946-9b85-580d7431461a', 'HAUTS-FR', 'DREAL Hauts-de-France', 'DREAL Hauts-de-France', '789249c4-feed-42ed-83f8-5af289fb7b38');
INSERT INTO cerbere.geo_group(id, code, name, description, cli_id) VALUES ('d7afef3d-2e5e-432a-9749-ec1cf61b7252', 'NORMANDIE', 'DREAL Normandie', 'DREAL Normandie', '789249c4-feed-42ed-83f8-5af289fb7b38');
INSERT INTO cerbere.geo_group(id, code, name, description, cli_id) VALUES ('d2f6dab2-1be6-45e3-9084-935376bfc66a', 'PAYS_LOIRE', 'DREAL Pays de la Loire', 'DREAL Pays de la Loire', '789249c4-feed-42ed-83f8-5af289fb7b38');
INSERT INTO cerbere.geo_group(id, code, name, description, cli_id) VALUES ('4a9e5218-62fa-4d71-83d7-b4c07a38c905', 'PROVENCE', 'DREAL Provence Alpes-Côte d’Azur', 'DREAL Provence Alpes-Côte d’Azur', '789249c4-feed-42ed-83f8-5af289fb7b38');

INSERT INTO cerbere.actor_geo_group(act_id, grp_id) VALUES ('c2a04887-d5cd-4c0a-a676-e1c295a72c2b', 'a3591813-6a01-45c4-ba8d-b424cf7607aa');
commit;

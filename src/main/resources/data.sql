INSERT IGNORE INTO Role (RoleID, Authority) VALUES (1, 'ROLE_USER');


INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(1, 'db5d6c60-b174-422b-82b5-663ed0bd8723', 1000000, 'Assets', 'An item purchased and owned that has monetary value', null, 0, false);
INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(2, 'dcbf0554-8d0a-4706-b98d-9a67359b2abb', 2000000, 'Liabilities', 'A liability is an obligation that arises in the course of doing business to be paid over a period of time', null, 0, false);
INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(3, '33ed413b-288b-4218-982c-7d3cd842f3ce', 3000000, 'Equity', "Shareholders' funds", null, 0, false);
INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(4, '4ec43749-b607-4951-9cc6-1e81d657c56c', 4000000, 'Income/Revenue', 'Income from normal business activity', null, 1, false);
INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(5, '8504eaa3-4830-4e70-959a-579b1973341b', 5000000, 'Cost of sales/goods', 'Costs related to sales or services you provide', null, 3, false);
INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(6, '4e0de115-6eaa-498e-82fa-34d4f87935f9', 6000000, 'Expenses', 'Expenses incurred in the business', null, 5, false);
INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(7, 'ef3eddf5-ef96-48e3-a50c-904161c60a50', 1100000, 'Fixed Assets', 'Fixed Assets', 'db5d6c60-b174-422b-82b5-663ed0bd8723', 31, false);
INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(8, '52fafb19-0891-4cf6-9f0e-cb9682458f36', 1200000, 'Current Assets', 'Current Assets', 'db5d6c60-b174-422b-82b5-663ed0bd8723', 32, false);
INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(9, '48094d7e-7bea-4e41-bfa3-37c937921ae4', 1210000, 'Cash', 'Cash', '52fafb19-0891-4cf6-9f0e-cb9682458f36', 33, false);
INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(10, '8923294d-022c-4ad9-a89f-de9c03965a8f', 1220000, 'Bank', 'Bank', '52fafb19-0891-4cf6-9f0e-cb9682458f36', 33, false);
INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(11, 'd8f6da33-58e9-48a9-8c26-0bb9fef7c87f', 3000001, "Owner's Contribution", "Owner's share capital contribution", '33ed413b-288b-4218-982c-7d3cd842f3ce', 0, false);
INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(12, '802d1e67-ae4c-4fde-869f-55793404b1c7', 3000002, "Owner's Distribution", "Owner's share capital distribution", '33ed413b-288b-4218-982c-7d3cd842f3ce', 0, false);






-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (2, '6c5bd845-93ec-4da8-a4a8-d195f0a96ea0', 2000000, 'Non-operating income', 'Income that isn’t from normal business operations', null, 2, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (4, 'a4b153c8-b69b-4243-9778-ed3dc9062d4d', 4000000, 'Direct cost', 'Costs incurred that relate directly to earning Income', null, 4, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (5, '4e0de115-6eaa-498e-82fa-34d4f87935f9', 5000000, 'Operating expenses', 'Expenses incurred from the day to day operations of the business', null, 5, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (6, '17dd80d1-6685-4e22-830e-c97f02f8a696', 6000000, 'Non-operating expenses', 'Expenditure that isn’t from normal business operations', null, 6, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (10, '1b7b337b-db56-4974-9a45-55b3022bf85f', 7100000, 'Current assets', 'Current assets', 'db5d6c60-b174-422b-82b5-663ed0bd8723', "N", false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (11, 'a59c1c6f-e58d-47e8-bfe2-1ff6d4dbce70', 1000001, 'Salary', 'Salaries and Wages', '4ec43749-b607-4951-9cc6-1e81d657c56c', 1, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (12, '43d4d661-9f47-4fe9-a12b-35512e00bd51', 2000002, 'Other Income', 'Other Income', '6c5bd845-93ec-4da8-a4a8-d195f0a96ea0', 2, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (13, 'a6f47bf0-42fa-4e44-b155-2a889b25b150', 2000003, 'Pensions and other benefits', 'Pensions and other benefits', '6c5bd845-93ec-4da8-a4a8-d195f0a96ea0', 3, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (14, 'db96ffc0-3b41-43dd-9ac0-f11be64a3312', 2000004, 'Savings', 'Savings', '6c5bd845-93ec-4da8-a4a8-d195f0a96ea0', 19, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (15, 'd1cb1b8c-1729-44be-b019-22356f7e7a75', 5000001, 'Accommodation and Housing', 'Accommodation and Housing', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 4, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (16, '4fd2b266-7abb-4340-991f-113bf425ff68', 5000002, 'Personal Insurance', 'Personal Insurance', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 5, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (17, '5e6c29af-7282-42cc-8f3e-5ab7f429bfc3', 5000003, 'Food', 'Food', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 6, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (18, '2af58408-4857-4f34-8589-d166da6c36df', 5000004, 'Utilities', 'Utilities', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 7, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (19, 'bbeb53ce-1d02-46a5-8112-ea4062468276', 5000005, 'Transportation', 'Transportation', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 8, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (20, '80de2c9b-1d24-40f2-bd56-97103d89cfc7', 5000006, 'Clothes', 'Clothes', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 9, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (21, '667fc465-1e36-4e83-b1b8-bc44f3ac98fa', 5000007, 'Leisure', 'Leisure', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 10, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (22, '94164203-b66e-4c22-a7b7-b8ddc6db385e', 5000008, 'Professional Development', 'Professional Development', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 11, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (23, '7c64cda1-8cc1-4270-9160-6a14ce0bf40d', 5000009, 'Health', 'Health', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 12, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (24, 'feff0a79-4c23-49da-b2ef-229973358bea', 5000010, 'Telecommunication', 'Telecommunication', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 16, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (25, 'b951756e-0113-4245-a133-9941af0ee567', 5000011, 'Education', 'Education', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 17, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (26, '5061c44b-7f2a-4b01-96a4-5086d515d126', 5000012, 'Personal Expenses', 'Personal Expenses', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 18, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (27, 'a62c1225-0af1-45ca-bc25-153bccf9d63f', 6000001, 'Debts', 'Debts', '17dd80d1-6685-4e22-830e-c97f02f8a696', 13, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (28, 'fbc00fc8-5bf4-4ed2-882e-25358d46a12f', 6000002, 'Charitable Donations', 'Charitable Donations', '17dd80d1-6685-4e22-830e-c97f02f8a696', 14, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (29, '79c54de6-79f2-4fe4-af1e-df56c15e0eac', 6000003, 'Emergency Funds', 'Emergency Funds', '17dd80d1-6685-4e22-830e-c97f02f8a696', 15, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (30, '2762dd61-ef5f-43f2-8f4c-91c8a395a192', 1000001, 'Sales/Income', 'Sales/Income', '4ec43749-b607-4951-9cc6-1e81d657c56c', 1, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (31, '2e5b6487-cb45-4f2d-94a1-469e5c9730f8', 3000001, 'Discounts', 'Discounts', '8504eaa3-4830-4e70-959a-579b1973341b', 3, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (32, 'bf02b91a-d22e-43bb-8e89-94e3a36b9a1d', 2000001, 'Other Income', 'Other Income', '6c5bd845-93ec-4da8-a4a8-d195f0a96ea0', 4, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (33, '80c615f5-897f-4db9-a168-acae4d791cf1', 10000000, 'Cost of Other Income', 'Cost of Other Income', null, 2, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (34, 'fbf339fa-0e25-41ea-831e-04cbb5781ed6', 4000001, 'Other Staff Cost', 'Other Staff Cost', 'a4b153c8-b69b-4243-9778-ed3dc9062d4d', 5, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (35, 'b55fe61a-a2bb-4dde-b78e-6439eb3a5083', 4000002, 'Staff Cost', 'Staff Cost', 'a4b153c8-b69b-4243-9778-ed3dc9062d4d', 6, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (36, '30968767-31c0-43db-9dfd-e91c86345220', 6000001, 'Depreciation', 'Depreciation', '17dd80d1-6685-4e22-830e-c97f02f8a696', 12, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (37, '874106cf-0adb-417c-be88-a7415226e5f6', 6000002, 'Exceptional Items', 'Exceptional Items', '17dd80d1-6685-4e22-830e-c97f02f8a696', 27, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (38, 'ef33b0b7-abb7-478f-8886-fc0f61c2bd6c', 5000001, 'Advertising', 'Advertising', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 7, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (39, 'b2fbbecd-f67b-48a2-8c62-2f72396bfde5', 5000002, 'Bad debts', 'Bad debts', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 8, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (40, 'ba199708-3328-411a-bc92-95954b9bde6e', 5000003, 'Entertaining', 'Entertaining', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 9, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (41, '747be3be-a24b-47ff-b46f-84403542b781', 5000004, 'Cleaning and Refuse', 'Cleaning and Refuse', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 10, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (42, 'cdbd7047-8adc-4017-b6c4-121587999c3f', 5000005, 'Consumables', 'Consumables', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 11, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (43, '9770ed9d-c545-4ae0-b4a8-a903f5c9ab82', 5000006, 'Equipment & Facility Hire', 'Equipment & Facility Hire', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 13, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (44, '78945797-7ebb-4334-9571-b16b6d663b7f', 5000007, 'Heat, Light & Power', 'Heat, Light & Power', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 14, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (45, '48fad14e-da66-4a9c-a84b-a426c73163ec', 5000008, 'Insurances', 'Insurances', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 15, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (46, '57f643f2-4754-4c3a-ab27-88e8c2fcec4f', 5000009, 'Information Technology Costs', 'Information Technology Costs', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 16, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (47, '06a042ff-e7bd-49c9-8c00-7fe5700056d7', 5000010, 'Legal and Professional', 'Legal and Professional', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 17, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (48, '136c1698-80a3-4d75-a4c8-edde0f95efdf', 5000011, 'Motor & Transport', 'Motor & Transport', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 18, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (49, '19874a8e-f532-4218-91f6-5daf045dad27', 5000012, 'Postage & Stationery', 'Postage & Stationery', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 19, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (50, '9c1ec23a-9722-4a75-9aae-679c4a186635', 5000013, 'Rates', 'Rates', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 20, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (51, '0def9de9-4c4d-44e4-b2c8-dd60b14ce342', 5000014, 'Rent', 'Rent', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 21, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (52, 'd0715947-2307-4c8b-aa2c-9e3ab187c026', 5000015, 'Repairs and Maintenance', 'Repairs and Maintenance', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 22, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (53, 'c18acd00-bbbe-450d-88ef-cd4d7f8e400c', 5000016, 'Security Costs', 'Security Costs', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 23, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (54, 'a683878e-3635-487e-8643-964352357e1c', 5000017, 'Sundries and Bank Charges', 'Sundries and Bank Charges', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 24, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (55, 'acba6b8a-fa8d-4118-96b0-b0dc3118486e', 5000018, 'Telephones', 'Telephones', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 25, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (56, '80409d0b-1857-43e7-9351-e0cdcd13ab0e', 5000019, 'Travel and Subsistence', 'Travel and Subsistence', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 26, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (57, '6fe9bdfd-3f39-45b1-a123-ad99e93db99c', 5000020, 'Tax', 'Tax', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 28, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (58, '3f2ceb18-8c34-4494-a655-849143dcab3e', 5000021, 'Suspense', 'Suspense', '4e0de115-6eaa-498e-82fa-34d4f87935f9', 29, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (61, 'e5d2ce48-2b77-4ed5-a20a-2ae5a431e676', 7000003, 'Non-current Assets', 'Non-current Assets', 'db5d6c60-b174-422b-82b5-663ed0bd8723', 30, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (62, '8923294d-022c-4ad9-a89f-de9c03965a8f', 7000004, 'Bank', 'Bank', 'db5d6c60-b174-422b-82b5-663ed0bd8723', 33, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (63, '2c28eefd-fbd7-4a89-9890-62062fd82aca', 8000001, 'Current Liabilities', 'Current Liabilities', 'dcbf0554-8d0a-4706-b98d-9a67359b2abb', 34, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (64, '103c107e-a28a-413b-b6ef-6470edb6044c', 8000002, 'Non-current Liabilities', 'Non-current Liabilities', 'dcbf0554-8d0a-4706-b98d-9a67359b2abb', 35, false);
-- INSERT IGNORE INTO Ledger_Template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
-- VALUES
-- (65, '52f0c071-b272-482d-a4bc-6d112e2a0b76', 9000001, 'Equity and Reserves', 'Equity and Reserves', '33ed413b-288b-4218-982c-7d3cd842f3ce', 36, false);

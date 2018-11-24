INSERT IGNORE INTO role (roleid, authority) VALUES (1, 'ROLE_USER');


INSERT IGNORE INTO ledger_template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(1, 'db5d6c60-b174-422b-82b5-663ed0bd8723', 1000000, 'Assets', 'An item purchased and owned that has monetary value', null, 0, false);
INSERT IGNORE INTO ledger_template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(2, 'dcbf0554-8d0a-4706-b98d-9a67359b2abb', 2000000, 'Liabilities', 'A liability is an obligation that arises in the course of doing business to be paid over a period of time', null, 0, false);
INSERT IGNORE INTO ledger_template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(3, '33ed413b-288b-4218-982c-7d3cd842f3ce', 3000000, 'Equity', "Shareholders' funds", null, 0, false);
INSERT IGNORE INTO ledger_template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(4, '4ec43749-b607-4951-9cc6-1e81d657c56c', 4000000, 'Income', 'Income from normal business activity', null, 1, false);
INSERT IGNORE INTO ledger_template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(5, '8504eaa3-4830-4e70-959a-579b1973341b', 5000000, 'Cost Of Sales/Goods', 'Costs related to sales or services you provide', null, 3, false);
INSERT IGNORE INTO ledger_template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(6, '4e0de115-6eaa-498e-82fa-34d4f87935f9', 6000000, 'Expenses', 'Expenses incurred in the business', null, 5, false);
INSERT IGNORE INTO ledger_template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(7, 'ef3eddf5-ef96-48e3-a50c-904161c60a50', 1100000, 'Fixed Assets', 'Fixed Assets', 'db5d6c60-b174-422b-82b5-663ed0bd8723', 31, false);
INSERT IGNORE INTO ledger_template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(8, '52fafb19-0891-4cf6-9f0e-cb9682458f36', 1200000, 'Current Assets', 'Current Assets', 'db5d6c60-b174-422b-82b5-663ed0bd8723', 32, false);
INSERT IGNORE INTO ledger_template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(9, '48094d7e-7bea-4e41-bfa3-37c937921ae4', 1210000, 'Cash', 'Cash', '52fafb19-0891-4cf6-9f0e-cb9682458f36', 33, false);
INSERT IGNORE INTO ledger_template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(10, '8923294d-022c-4ad9-a89f-de9c03965a8f', 1220000, 'Bank', 'Bank', '52fafb19-0891-4cf6-9f0e-cb9682458f36', 33, false);
INSERT IGNORE INTO ledger_template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(11, 'd8f6da33-58e9-48a9-8c26-0bb9fef7c87f', 3000001, "Owner's Contribution", "Owner's share capital contribution", '33ed413b-288b-4218-982c-7d3cd842f3ce', 0, false);
INSERT IGNORE INTO ledger_template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(12, '802d1e67-ae4c-4fde-869f-55793404b1c7', 3000002, "Dividends/Owner's Distribution", "Owner's share capital distribution", '33ed413b-288b-4218-982c-7d3cd842f3ce', 0, false);
INSERT IGNORE INTO ledger_template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(13, '10b22328-a437-424f-8a99-9ed77bf2263f', 4100000, "Sales Income", "Income from sales", '4ec43749-b607-4951-9cc6-1e81d657c56c', 0, false);
INSERT IGNORE INTO ledger_template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(14, 'b0abf3bd-4cf8-4b2a-927a-a266545859c0', 4200000, "Sales Discount", "Discount on sales", '4ec43749-b607-4951-9cc6-1e81d657c56c', 0, false);
INSERT IGNORE INTO ledger_template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(15, '0a5208c8-cf2f-435c-9544-f2009ec5a220', 4300000, "Sales Return", "Return on sales", '4ec43749-b607-4951-9cc6-1e81d657c56c', 0, false);
INSERT IGNORE INTO ledger_template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(16, '2fa95b04-3276-46c1-9aa3-6b31e5e7dbcf', 5100000, "Purchases", "Cost of purchases", '8504eaa3-4830-4e70-959a-579b1973341b', 0, false);
INSERT IGNORE INTO ledger_template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(17, '7c26db05-e6fd-43bc-aa65-ed6d5133a1d3', 5200000, "Purchases Discount", "Discount on purchases", '8504eaa3-4830-4e70-959a-579b1973341b', 0, false);
INSERT IGNORE INTO ledger_template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(18, 'a243bafc-f025-4b0f-b4af-63ab0a755a0c', 5300000, "Purchases Return", "Return on puchases", '8504eaa3-4830-4e70-959a-579b1973341b', 0, false);
INSERT IGNORE INTO ledger_template (ledger_templateid, uuid, code, name, description, parent_uuid, report_sort_order, show_on_dashboard)
VALUES
(18, 'e495bd65-df82-4b58-bb1e-4f62be92dead', 5400000, "Stock", "Product, commodity or goods", '8504eaa3-4830-4e70-959a-579b1973341b', 0, false);
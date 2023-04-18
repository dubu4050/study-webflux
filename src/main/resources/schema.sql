CREATE TABLE item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    item_nm VARCHAR(255) NOT NULL,
    price INTEGER NOT NULL,
    stock_number INTEGER NOT NULL,
    item_detail VARCHAR(255) NOT NULL,
    item_sell_status VARCHAR(255) NOT NULL,
    reg_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for m_city
-- ----------------------------
DROP TABLE IF EXISTS `m_city`;
CREATE TABLE `m_city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(45) NOT NULL,
  `local_city_name` varchar(45) DEFAULT NULL,
  `country_id` int(11) DEFAULT '0',
  `district` varchar(45) DEFAULT NULL,
  `population` int(11) DEFAULT '0',
  `date_modified` datetime DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  PRIMARY KEY (`city_id`),
  KEY `cities_fk_country` (`country_id`),
  CONSTRAINT `cities_fk_country` FOREIGN KEY (`country_id`) REFERENCES `m_country` (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2252 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of m_city
-- ----------------------------
INSERT INTO `m_city` VALUES ('1', 'Kabul', null, '482', 'Kabol', '1780000', '2019-08-27 22:38:39', '2019-08-27 22:38:39');
INSERT INTO `m_city` VALUES ('1890', 'Shanghai', null, '522', 'Shanghai', '9696300', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1891', 'Peking', null, '522', 'Peking', '7472000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1892', 'Chongqing', null, '522', 'Chongqing', '6351600', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1893', 'Tianjin', null, '522', 'Tianjin', '5286800', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1894', 'Wuhan', null, '522', 'Hubei', '4344600', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1895', 'Harbin', null, '522', 'Heilongjiang', '4289800', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1896', 'Shenyang', null, '522', 'Liaoning', '4265200', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1897', 'Kanton [Guangzhou]', null, '522', 'Guangdong', '4256300', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1898', 'Chengdu', null, '522', 'Sichuan', '3361500', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1899', 'Nanking [Nanjing]', null, '522', 'Jiangsu', '2870300', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1900', 'Changchun', null, '522', 'Jilin', '2812000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1902', 'Dalian', null, '522', 'Liaoning', '2697000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1903', 'Qingdao', null, '522', 'Shandong', '2596000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1904', 'Jinan', null, '522', 'Shandong', '2278100', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1905', 'Hangzhou', null, '522', 'Zhejiang', '2190500', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1906', 'Zhengzhou', null, '522', 'Henan', '2107200', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1907', 'Shijiazhuang', null, '522', 'Hebei', '2041500', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1908', 'Taiyuan', null, '522', 'Shanxi', '1968400', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1909', 'Kunming', null, '522', 'Yunnan', '1829500', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1910', 'Changsha', null, '522', 'Hunan', '1809800', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1911', 'Nanchang', null, '522', 'Jiangxi', '1691600', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1912', 'Fuzhou', null, '522', 'Fujian', '1593800', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1913', 'Lanzhou', null, '522', 'Gansu', '1565800', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1914', 'Guiyang', null, '522', 'Guizhou', '1465200', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1915', 'Ningbo', null, '522', 'Zhejiang', '1371200', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1916', 'Hefei', null, '522', 'Anhui', '1369100', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1918', 'Anshan', null, '522', 'Liaoning', '1200000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1919', 'Fushun', null, '522', 'Liaoning', '1200000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1920', 'Nanning', null, '522', 'Guangxi', '1161800', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1921', 'Zibo', null, '522', 'Shandong', '1140000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1922', 'Qiqihar', null, '522', 'Heilongjiang', '1070000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1923', 'Jilin', null, '522', 'Jilin', '1040000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1924', 'Tangshan', null, '522', 'Hebei', '1040000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1925', 'Baotou', null, '522', 'Inner Mongolia', '980000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1926', 'Shenzhen', null, '522', 'Guangdong', '950500', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1927', 'Hohhot', null, '522', 'Inner Mongolia', '916700', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1928', 'Handan', null, '522', 'Hebei', '840000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1929', 'Wuxi', null, '522', 'Jiangsu', '830000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1930', 'Xuzhou', null, '522', 'Jiangsu', '810000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1931', 'Datong', null, '522', 'Shanxi', '800000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1932', 'Yichun', null, '522', 'Heilongjiang', '800000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1933', 'Benxi', null, '522', 'Liaoning', '770000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1934', 'Luoyang', null, '522', 'Henan', '760000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1935', 'Suzhou', null, '522', 'Jiangsu', '710000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1936', 'Xining', null, '522', 'Qinghai', '700200', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1937', 'Huainan', null, '522', 'Anhui', '700000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1938', 'Jixi', null, '522', 'Heilongjiang', '683885', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1939', 'Daqing', null, '522', 'Heilongjiang', '660000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1940', 'Fuxin', null, '522', 'Liaoning', '640000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1941', 'Amoy [Xiamen]', null, '522', 'Fujian', '627500', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1942', 'Liuzhou', null, '522', 'Guangxi', '610000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1943', 'Shantou', null, '522', 'Guangdong', '580000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1944', 'Jinzhou', null, '522', 'Liaoning', '570000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1945', 'Mudanjiang', null, '522', 'Heilongjiang', '570000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1946', 'Yinchuan', null, '522', 'Ningxia', '544500', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1947', 'Changzhou', null, '522', 'Jiangsu', '530000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1948', 'Zhangjiakou', null, '522', 'Hebei', '530000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1949', 'Dandong', null, '522', 'Liaoning', '520000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1950', 'Hegang', null, '522', 'Heilongjiang', '520000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1951', 'Kaifeng', null, '522', 'Henan', '510000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1952', 'Jiamusi', null, '522', 'Heilongjiang', '493409', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1953', 'Liaoyang', null, '522', 'Liaoning', '492559', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1954', 'Hengyang', null, '522', 'Hunan', '487148', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1955', 'Baoding', null, '522', 'Hebei', '483155', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1956', 'Hunjiang', null, '522', 'Jilin', '482043', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1957', 'Xinxiang', null, '522', 'Henan', '473762', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1958', 'Huangshi', null, '522', 'Hubei', '457601', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1959', 'Haikou', null, '522', 'Hainan', '454300', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1960', 'Yantai', null, '522', 'Shandong', '452127', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1961', 'Bengbu', null, '522', 'Anhui', '449245', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1962', 'Xiangtan', null, '522', 'Hunan', '441968', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1963', 'Weifang', null, '522', 'Shandong', '428522', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1964', 'Wuhu', null, '522', 'Anhui', '425740', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1965', 'Pingxiang', null, '522', 'Jiangxi', '425579', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1966', 'Yingkou', null, '522', 'Liaoning', '421589', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1967', 'Anyang', null, '522', 'Henan', '420332', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1968', 'Panzhihua', null, '522', 'Sichuan', '415466', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1969', 'Pingdingshan', null, '522', 'Henan', '410775', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1970', 'Xiangfan', null, '522', 'Hubei', '410407', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1971', 'Zhuzhou', null, '522', 'Hunan', '409924', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1972', 'Jiaozuo', null, '522', 'Henan', '409100', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1973', 'Wenzhou', null, '522', 'Zhejiang', '401871', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1974', 'Zhangjiang', null, '522', 'Guangdong', '400997', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1975', 'Zigong', null, '522', 'Sichuan', '393184', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1976', 'Shuangyashan', null, '522', 'Heilongjiang', '386081', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1977', 'Zaozhuang', null, '522', 'Shandong', '380846', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1978', 'Yakeshi', null, '522', 'Inner Mongolia', '377869', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1979', 'Yichang', null, '522', 'Hubei', '371601', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1980', 'Zhenjiang', null, '522', 'Jiangsu', '368316', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1981', 'Huaibei', null, '522', 'Anhui', '366549', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1982', 'Qinhuangdao', null, '522', 'Hebei', '364972', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1983', 'Guilin', null, '522', 'Guangxi', '364130', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1984', 'Liupanshui', null, '522', 'Guizhou', '363954', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1985', 'Panjin', null, '522', 'Liaoning', '362773', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1986', 'Yangquan', null, '522', 'Shanxi', '362268', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1987', 'Jinxi', null, '522', 'Liaoning', '357052', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1988', 'Liaoyuan', null, '522', 'Jilin', '354141', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1989', 'Lianyungang', null, '522', 'Jiangsu', '354139', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1990', 'Xianyang', null, '522', 'Shaanxi', '352125', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1992', 'Chifeng', null, '522', 'Inner Mongolia', '350077', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1993', 'Shaoguan', null, '522', 'Guangdong', '350043', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1994', 'Nantong', null, '522', 'Jiangsu', '343341', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1995', 'Leshan', null, '522', 'Sichuan', '341128', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1996', 'Baoji', null, '522', 'Shaanxi', '337765', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1997', 'Linyi', null, '522', 'Shandong', '324720', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1998', 'Tonghua', null, '522', 'Jilin', '324600', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('1999', 'Siping', null, '522', 'Jilin', '317223', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2000', 'Changzhi', null, '522', 'Shanxi', '317144', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2001', 'Tengzhou', null, '522', 'Shandong', '315083', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2002', 'Chaozhou', null, '522', 'Guangdong', '313469', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2003', 'Yangzhou', null, '522', 'Jiangsu', '312892', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2004', 'Dongwan', null, '522', 'Guangdong', '308669', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2006', 'Foshan', null, '522', 'Guangdong', '303160', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2007', 'Yueyang', null, '522', 'Hunan', '302800', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2008', 'Xingtai', null, '522', 'Hebei', '302789', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2009', 'Changde', null, '522', 'Hunan', '301276', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2010', 'Shihezi', null, '522', 'Xinxiang', '299676', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2011', 'Yancheng', null, '522', 'Jiangsu', '296831', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2012', 'Jiujiang', null, '522', 'Jiangxi', '291187', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2013', 'Dongying', null, '522', 'Shandong', '281728', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2014', 'Shashi', null, '522', 'Hubei', '281352', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2015', 'Xintai', null, '522', 'Shandong', '281248', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2016', 'Jingdezhen', null, '522', 'Jiangxi', '281183', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2017', 'Tongchuan', null, '522', 'Shaanxi', '280657', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2018', 'Zhongshan', null, '522', 'Guangdong', '278829', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2019', 'Shiyan', null, '522', 'Hubei', '273786', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2020', 'Tieli', null, '522', 'Heilongjiang', '265683', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2021', 'Jining', null, '522', 'Shandong', '265248', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2022', 'Wuhai', null, '522', 'Inner Mongolia', '264081', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2023', 'Mianyang', null, '522', 'Sichuan', '262947', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2024', 'Luzhou', null, '522', 'Sichuan', '262892', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2025', 'Zunyi', null, '522', 'Guizhou', '261862', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2026', 'Shizuishan', null, '522', 'Ningxia', '257862', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2027', 'Neijiang', null, '522', 'Sichuan', '256012', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2028', 'Tongliao', null, '522', 'Inner Mongolia', '255129', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2029', 'Tieling', null, '522', 'Liaoning', '254842', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2030', 'Wafangdian', null, '522', 'Liaoning', '251733', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2031', 'Anqing', null, '522', 'Anhui', '250718', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2032', 'Shaoyang', null, '522', 'Hunan', '247227', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2033', 'Laiwu', null, '522', 'Shandong', '246833', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2034', 'Chengde', null, '522', 'Hebei', '246799', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2035', 'Tianshui', null, '522', 'Gansu', '244974', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2036', 'Nanyang', null, '522', 'Henan', '243303', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2037', 'Cangzhou', null, '522', 'Hebei', '242708', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2038', 'Yibin', null, '522', 'Sichuan', '241019', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2039', 'Huaiyin', null, '522', 'Jiangsu', '239675', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2040', 'Dunhua', null, '522', 'Jilin', '235100', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2041', 'Yanji', null, '522', 'Jilin', '230892', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2042', 'Jiangmen', null, '522', 'Guangdong', '230587', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2043', 'Tongling', null, '522', 'Anhui', '228017', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2044', 'Suihua', null, '522', 'Heilongjiang', '227881', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2045', 'Gongziling', null, '522', 'Jilin', '226569', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2046', 'Xiantao', null, '522', 'Hubei', '222884', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2047', 'Chaoyang', null, '522', 'Liaoning', '222394', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2048', 'Ganzhou', null, '522', 'Jiangxi', '220129', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2049', 'Huzhou', null, '522', 'Zhejiang', '218071', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2050', 'Baicheng', null, '522', 'Jilin', '217987', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2051', 'Shangzi', null, '522', 'Heilongjiang', '215373', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2052', 'Yangjiang', null, '522', 'Guangdong', '215196', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2053', 'Qitaihe', null, '522', 'Heilongjiang', '214957', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2054', 'Gejiu', null, '522', 'Yunnan', '214294', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2055', 'Jiangyin', null, '522', 'Jiangsu', '213659', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2056', 'Hebi', null, '522', 'Henan', '212976', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2057', 'Jiaxing', null, '522', 'Zhejiang', '211526', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2058', 'Wuzhou', null, '522', 'Guangxi', '210452', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2059', 'Meihekou', null, '522', 'Jilin', '209038', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2060', 'Xuchang', null, '522', 'Henan', '208815', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2061', 'Liaocheng', null, '522', 'Shandong', '207844', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2062', 'Haicheng', null, '522', 'Liaoning', '205560', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2063', 'Qianjiang', null, '522', 'Hubei', '205504', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2064', 'Baiyin', null, '522', 'Gansu', '204970', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2066', 'Yixing', null, '522', 'Jiangsu', '200824', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2067', 'Laizhou', null, '522', 'Shandong', '198664', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2068', 'Qaramay', null, '522', 'Xinxiang', '197602', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2069', 'Acheng', null, '522', 'Heilongjiang', '197595', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2070', 'Dezhou', null, '522', 'Shandong', '195485', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2071', 'Nanping', null, '522', 'Fujian', '195064', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2072', 'Zhaoqing', null, '522', 'Guangdong', '194784', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2073', 'Beipiao', null, '522', 'Liaoning', '194301', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2074', 'Fengcheng', null, '522', 'Jiangxi', '193784', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2075', 'Fuyu', null, '522', 'Jilin', '192981', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2076', 'Xinyang', null, '522', 'Henan', '192509', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2077', 'Dongtai', null, '522', 'Jiangsu', '192247', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2078', 'Yuci', null, '522', 'Shanxi', '191356', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2079', 'Honghu', null, '522', 'Hubei', '190772', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2080', 'Ezhou', null, '522', 'Hubei', '190123', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2081', 'Heze', null, '522', 'Shandong', '189293', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2082', 'Daxian', null, '522', 'Sichuan', '188101', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2083', 'Linfen', null, '522', 'Shanxi', '187309', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2084', 'Tianmen', null, '522', 'Hubei', '186332', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2085', 'Yiyang', null, '522', 'Hunan', '185818', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2086', 'Quanzhou', null, '522', 'Fujian', '185154', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2087', 'Rizhao', null, '522', 'Shandong', '185048', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2088', 'Deyang', null, '522', 'Sichuan', '182488', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2089', 'Guangyuan', null, '522', 'Sichuan', '182241', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2090', 'Changshu', null, '522', 'Jiangsu', '181805', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2091', 'Zhangzhou', null, '522', 'Fujian', '181424', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2092', 'Hailar', null, '522', 'Inner Mongolia', '180650', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2093', 'Nanchong', null, '522', 'Sichuan', '180273', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2094', 'Jiutai', null, '522', 'Jilin', '180130', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2095', 'Zhaodong', null, '522', 'Heilongjiang', '179976', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2096', 'Shaoxing', null, '522', 'Zhejiang', '179818', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2097', 'Fuyang', null, '522', 'Anhui', '179572', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2098', 'Maoming', null, '522', 'Guangdong', '178683', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2099', 'Qujing', null, '522', 'Yunnan', '178669', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2100', 'Ghulja', null, '522', 'Xinxiang', '177193', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2101', 'Jiaohe', null, '522', 'Jilin', '176367', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2102', 'Puyang', null, '522', 'Henan', '175988', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2103', 'Huadian', null, '522', 'Jilin', '175873', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2104', 'Jiangyou', null, '522', 'Sichuan', '175753', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2105', 'Qashqar', null, '522', 'Xinxiang', '174570', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2106', 'Anshun', null, '522', 'Guizhou', '174142', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2107', 'Fuling', null, '522', 'Sichuan', '173878', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2108', 'Xinyu', null, '522', 'Jiangxi', '173524', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2109', 'Hanzhong', null, '522', 'Shaanxi', '169930', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2110', 'Danyang', null, '522', 'Jiangsu', '169603', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2111', 'Chenzhou', null, '522', 'Hunan', '169400', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2112', 'Xiaogan', null, '522', 'Hubei', '166280', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2113', 'Shangqiu', null, '522', 'Henan', '164880', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2114', 'Zhuhai', null, '522', 'Guangdong', '164747', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2115', 'Qingyuan', null, '522', 'Guangdong', '164641', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2116', 'Aqsu', null, '522', 'Xinxiang', '164092', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2117', 'Jining', null, '522', 'Inner Mongolia', '163552', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2118', 'Xiaoshan', null, '522', 'Zhejiang', '162930', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2119', 'Zaoyang', null, '522', 'Hubei', '162198', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2120', 'Xinghua', null, '522', 'Jiangsu', '161910', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2121', 'Hami', null, '522', 'Xinxiang', '161315', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2122', 'Huizhou', null, '522', 'Guangdong', '161023', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2123', 'Jinmen', null, '522', 'Hubei', '160794', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2124', 'Sanming', null, '522', 'Fujian', '160691', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2125', 'Ulanhot', null, '522', 'Inner Mongolia', '159538', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2126', 'Korla', null, '522', 'Xinxiang', '159344', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2127', 'Wanxian', null, '522', 'Sichuan', '156823', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2129', 'Zhoushan', null, '522', 'Zhejiang', '156317', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2130', 'Liangcheng', null, '522', 'Shandong', '156307', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2131', 'Jiaozhou', null, '522', 'Shandong', '153364', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2132', 'Taizhou', null, '522', 'Jiangsu', '152442', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2133', 'Suzhou', null, '522', 'Anhui', '151862', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2134', 'Yichun', null, '522', 'Jiangxi', '151585', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2135', 'Taonan', null, '522', 'Jilin', '150168', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2136', 'Pingdu', null, '522', 'Shandong', '150123', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2138', 'Longkou', null, '522', 'Shandong', '148362', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2139', 'Langfang', null, '522', 'Hebei', '148105', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2140', 'Zhoukou', null, '522', 'Henan', '146288', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2141', 'Suining', null, '522', 'Sichuan', '146086', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2142', 'Yulin', null, '522', 'Guangxi', '144467', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2143', 'Jinhua', null, '522', 'Zhejiang', '144280', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2145', 'Shuangcheng', null, '522', 'Heilongjiang', '142659', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2146', 'Suizhou', null, '522', 'Hubei', '142302', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2147', 'Ankang', null, '522', 'Shaanxi', '142170', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2148', 'Weinan', null, '522', 'Shaanxi', '140169', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2149', 'Longjing', null, '522', 'Jilin', '139417', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2151', 'Lengshuijiang', null, '522', 'Hunan', '137994', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2152', 'Laiyang', null, '522', 'Shandong', '137080', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2153', 'Xianning', null, '522', 'Hubei', '136811', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2154', 'Dali', null, '522', 'Yunnan', '136554', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2155', 'Anda', null, '522', 'Heilongjiang', '136446', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2156', 'Jincheng', null, '522', 'Shanxi', '136396', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2157', 'Longyan', null, '522', 'Fujian', '134481', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2158', 'Xichang', null, '522', 'Sichuan', '134419', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2159', 'Wendeng', null, '522', 'Shandong', '133910', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2160', 'Hailun', null, '522', 'Heilongjiang', '133565', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2161', 'Binzhou', null, '522', 'Shandong', '133555', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2162', 'Linhe', null, '522', 'Inner Mongolia', '133183', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2163', 'Wuwei', null, '522', 'Gansu', '133101', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2164', 'Duyun', null, '522', 'Guizhou', '132971', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2165', 'Mishan', null, '522', 'Heilongjiang', '132744', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2166', 'Shangrao', null, '522', 'Jiangxi', '132455', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2167', 'Changji', null, '522', 'Xinxiang', '132260', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2168', 'Meixian', null, '522', 'Guangdong', '132156', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2169', 'Yushu', null, '522', 'Jilin', '131861', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2170', 'Tiefa', null, '522', 'Liaoning', '131807', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2172', 'Leiyang', null, '522', 'Hunan', '130115', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2173', 'Zalantun', null, '522', 'Inner Mongolia', '130031', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2174', 'Weihai', null, '522', 'Shandong', '128888', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2175', 'Loudi', null, '522', 'Hunan', '128418', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2176', 'Qingzhou', null, '522', 'Shandong', '128258', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2177', 'Qidong', null, '522', 'Jiangsu', '126872', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2178', 'Huaihua', null, '522', 'Hunan', '126785', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2179', 'Luohe', null, '522', 'Henan', '126438', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2180', 'Chuzhou', null, '522', 'Anhui', '125341', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2181', 'Kaiyuan', null, '522', 'Liaoning', '124219', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2182', 'Linqing', null, '522', 'Shandong', '123958', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2183', 'Chaohu', null, '522', 'Anhui', '123676', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2184', 'Laohekou', null, '522', 'Hubei', '123366', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2185', 'Dujiangyan', null, '522', 'Sichuan', '123357', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2186', 'Zhumadian', null, '522', 'Henan', '123232', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2187', 'Linchuan', null, '522', 'Jiangxi', '121949', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2188', 'Jiaonan', null, '522', 'Shandong', '121397', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2189', 'Sanmenxia', null, '522', 'Henan', '120523', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2190', 'Heyuan', null, '522', 'Guangdong', '120101', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2191', 'Manzhouli', null, '522', 'Inner Mongolia', '120023', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2192', 'Lhasa', null, '522', 'Tibet', '120000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2193', 'Lianyuan', null, '522', 'Hunan', '118858', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2194', 'Kuytun', null, '522', 'Xinxiang', '118553', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2195', 'Puqi', null, '522', 'Hubei', '117264', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2196', 'Hongjiang', null, '522', 'Hunan', '116188', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2197', 'Qinzhou', null, '522', 'Guangxi', '114586', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2198', 'Renqiu', null, '522', 'Hebei', '114256', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2199', 'Yuyao', null, '522', 'Zhejiang', '114065', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2200', 'Guigang', null, '522', 'Guangxi', '114025', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2201', 'Kaili', null, '522', 'Guizhou', '113958', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2203', 'Beihai', null, '522', 'Guangxi', '112673', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2204', 'Xuangzhou', null, '522', 'Anhui', '112673', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2205', 'Quzhou', null, '522', 'Zhejiang', '112373', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2207', 'Zixing', null, '522', 'Hunan', '110048', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2208', 'Liyang', null, '522', 'Jiangsu', '109520', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2209', 'Yizheng', null, '522', 'Jiangsu', '109268', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2210', 'Yumen', null, '522', 'Gansu', '109234', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2211', 'Liling', null, '522', 'Hunan', '108504', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2212', 'Yuncheng', null, '522', 'Shanxi', '108359', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2213', 'Shanwei', null, '522', 'Guangdong', '107847', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2214', 'Cixi', null, '522', 'Zhejiang', '107329', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2215', 'Yuanjiang', null, '522', 'Hunan', '107004', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2216', 'Bozhou', null, '522', 'Anhui', '106346', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2217', 'Jinchang', null, '522', 'Gansu', '105287', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2219', 'Suqian', null, '522', 'Jiangsu', '105021', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2220', 'Shishou', null, '522', 'Hubei', '104571', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2221', 'Hengshui', null, '522', 'Hebei', '104269', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2222', 'Danjiangkou', null, '522', 'Hubei', '103211', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2223', 'Fujin', null, '522', 'Heilongjiang', '103104', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2224', 'Sanya', null, '522', 'Hainan', '102820', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2225', 'Guangshui', null, '522', 'Hubei', '102770', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2226', 'Huangshan', null, '522', 'Anhui', '102628', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2227', 'Xingcheng', null, '522', 'Liaoning', '102384', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2228', 'Zhucheng', null, '522', 'Shandong', '102134', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2229', 'Kunshan', null, '522', 'Jiangsu', '102052', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2230', 'Haining', null, '522', 'Zhejiang', '100478', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2231', 'Pingliang', null, '522', 'Gansu', '99265', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2232', 'Fuqing', null, '522', 'Fujian', '99193', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2233', 'Xinzhou', null, '522', 'Shanxi', '98667', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2234', 'Jieyang', null, '522', 'Guangdong', '98531', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2235', 'Zhangjiagang', null, '522', 'Jiangsu', '97994', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2236', 'Tong Xian', null, '522', 'Peking', '97168', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2238', 'Jinzhou', null, '522', 'Liaoning', '95761', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2239', 'Emeishan', null, '522', 'Sichuan', '94000', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2240', 'Enshi', null, '522', 'Hubei', '93056', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2241', 'Bose', null, '522', 'Guangxi', '93009', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2242', 'Yuzhou', null, '522', 'Henan', '92889', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2243', 'Kaiyuan', null, '522', 'Yunnan', '91999', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2244', 'Tumen', null, '522', 'Jilin', '91471', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2245', 'Putian', null, '522', 'Fujian', '91030', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2246', 'Linhai', null, '522', 'Zhejiang', '90870', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2247', 'Xilin Hot', null, '522', 'Inner Mongolia', '90646', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2248', 'Shaowu', null, '522', 'Fujian', '90286', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2249', 'Junan', null, '522', 'Shandong', '90222', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2250', 'Huaying', null, '522', 'Sichuan', '89400', '2019-08-27 22:38:40', '2019-08-27 22:38:40');
INSERT INTO `m_city` VALUES ('2251', 'Pingyi', null, '522', 'Shandong', '89373', '2019-08-27 22:38:40', '2019-08-27 22:38:40');

-- ----------------------------
-- Table structure for m_country
-- ----------------------------
DROP TABLE IF EXISTS `m_country`;
CREATE TABLE `m_country` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(50) NOT NULL,
  `local_country_name` varchar(45) DEFAULT NULL,
  `country_code` varchar(20) NOT NULL,
  `country_code2` varchar(20) DEFAULT NULL,
  `continent` enum('Asia','Europe','North America','Africa','Oceania','Antarctica','South America') DEFAULT 'Asia',
  `region` varchar(45) DEFAULT NULL,
  `surface_area` float(10,2) DEFAULT NULL,
  `indep_year` int(11) DEFAULT NULL,
  `population` int(11) DEFAULT NULL,
  `life_expectancy` float DEFAULT NULL,
  `gnp` float(10,2) DEFAULT NULL,
  `government_form` varchar(45) DEFAULT NULL,
  `head_of_state` varchar(60) DEFAULT NULL,
  `capital` int(11) DEFAULT '0',
  `time_zone` varchar(50) DEFAULT NULL,
  `language_id` int(11) DEFAULT '0',
  `currency_id` int(11) DEFAULT '0',
  `date_modified` datetime DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  PRIMARY KEY (`country_id`),
  UNIQUE KEY `country_code_UNIQUE` (`country_code`)
) ENGINE=InnoDB AUTO_INCREMENT=523 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of m_country
-- ----------------------------
INSERT INTO `m_country` VALUES ('481', 'Aruba', 'Aruba', 'ABW', 'AW', 'North America', 'Caribbean', '193.00', null, '103000', '78.4', '828.00', 'Nonmetropolitan Territory of The Netherlands', 'Beatrix', '1935', null, '0', '0', '2019-08-27 22:38:39', '2019-08-27 22:38:39');
INSERT INTO `m_country` VALUES ('482', 'Afghanistan', 'Afganistan/Afqanestan', 'AFG', 'AF', 'Asia', 'Southern and Central Asia', '652090.00', '1919', '22720000', '45.9', '5976.00', 'Islamic Emirate', 'Mohammad Omar', '1', null, '0', '0', '2019-08-27 22:38:39', '2019-08-27 22:38:39');
INSERT INTO `m_country` VALUES ('522', 'China', 'Zhongquo', 'CHN', 'CN', 'Asia', 'Eastern Asia', '9572900.00', '-1523', '1277558000', '71.4', '982268.00', 'People\'sRepublic', 'Jiang Zemin', '1891', null, '0', '0', '2019-08-27 22:38:39', '2019-08-27 22:38:39');

-- ----------------------------
-- Table structure for m_file
-- ----------------------------
DROP TABLE IF EXISTS `m_file`;
CREATE TABLE `m_file` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` char(50) DEFAULT NULL,
  `file_description` varchar(255) DEFAULT NULL,
  `file_size` varchar(255) DEFAULT NULL,
  `file_url` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `upload_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_file
-- ----------------------------
INSERT INTO `m_file` VALUES ('1', 'history.sqlite', '66666', '28.0', 'D:/UploadFile\\history.sqlite', '2020-02-12 19:49:10', '2');
INSERT INTO `m_file` VALUES ('2', '6.jpg', '666666', '356.302734375', 'D:/UploadFile\\6.jpg', '2020-02-12 11:49:29', '0');
INSERT INTO `m_file` VALUES ('3', '107830-106.jpg', '666666', '563.501953125', 'D:/UploadFile\\107830-106.jpg', '2020-02-12 11:49:29', '0');
INSERT INTO `m_file` VALUES ('4', '5.jpg', 'asdas', '710.927734375', 'D:/UploadFile\\5.jpg', '2020-02-27 10:58:09', '0');

-- ----------------------------
-- Table structure for m_resource
-- ----------------------------
DROP TABLE IF EXISTS `m_resource`;
CREATE TABLE `m_resource` (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_uri` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_resource
-- ----------------------------
INSERT INTO `m_resource` VALUES ('1', 'deleteUser', '/deleteUser');
INSERT INTO `m_resource` VALUES ('2', 'updteUser', '/updateUser');
INSERT INTO `m_resource` VALUES ('3', 'insUer', '/insUser');

-- ----------------------------
-- Table structure for m_role
-- ----------------------------
DROP TABLE IF EXISTS `m_role`;
CREATE TABLE `m_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_role
-- ----------------------------
INSERT INTO `m_role` VALUES ('1', 'admin');
INSERT INTO `m_role` VALUES ('2', 'manager');
INSERT INTO `m_role` VALUES ('3', 'staff');

-- ----------------------------
-- Table structure for m_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `m_role_resource`;
CREATE TABLE `m_role_resource` (
  `role_resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_role_resource
-- ----------------------------
INSERT INTO `m_role_resource` VALUES ('1', '1', '1');
INSERT INTO `m_role_resource` VALUES ('2', '1', '2');
INSERT INTO `m_role_resource` VALUES ('3', '1', '3');
INSERT INTO `m_role_resource` VALUES ('4', '2', '1');
INSERT INTO `m_role_resource` VALUES ('5', '2', '2');
INSERT INTO `m_role_resource` VALUES ('15', '3', '3');

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `remove_state` int(11) DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_user
-- ----------------------------
INSERT INTO `m_user` VALUES ('1', '2020-01-29 16:00:00', '5f329d3ac22671f7b214c461e58c27f3', 'admin', '0');
INSERT INTO `m_user` VALUES ('2', '2020-02-19 16:00:00', '5f329d3ac22671f7b214c461e58c27f3', 'manager', '0');
INSERT INTO `m_user` VALUES ('3', '2020-02-16 16:00:00', '5f329d3ac22671f7b214c461e58c27f3', 'staff', '0');
INSERT INTO `m_user` VALUES ('4', '2020-02-07 15:58:33', '7df1f6edd67aa182d7902528788e2982', 'zhaopeng', '1');
INSERT INTO `m_user` VALUES ('5', '2020-03-11 10:55:35', '3d0876d9d6728781276b2834316c7484', 'admins', '1');
INSERT INTO `m_user` VALUES ('6', '2020-03-11 11:05:15', '0f2904c33afd448093c9396d2f573bf8', 'adminss', '1');

-- ----------------------------
-- Table structure for m_user_role
-- ----------------------------
DROP TABLE IF EXISTS `m_user_role`;
CREATE TABLE `m_user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_user_role
-- ----------------------------
INSERT INTO `m_user_role` VALUES ('14', '1', '1');
INSERT INTO `m_user_role` VALUES ('23', '4', '3');
INSERT INTO `m_user_role` VALUES ('25', '5', '3');
INSERT INTO `m_user_role` VALUES ('26', '6', '9');
INSERT INTO `m_user_role` VALUES ('27', '2', '2');
INSERT INTO `m_user_role` VALUES ('28', '3', '3');

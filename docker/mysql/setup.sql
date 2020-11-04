create database test_db CHARACTER SET utf8 COLLATE utf8_general_ci;

USE test_db;

CREATE TABLE `users`(
   `id` int(11) not null,
   `name` char(20) default null,
   primary key(`id`)
) engine=innodb default charset=utf8;

CREATE TABLE `member`(
   `mem_id` int(11) not null,
   `mem_name` varchar(12) default null,
   `mem_email` varchar(20) default null,
   `mem_password` varchar(1024) default null,
   `mem_grade` varchar(20) default null,
   `mem_point` varchar(20) default null,
   `mem_homepage` varchar(20) default null,
   `mem_phone` varchar(20) default null,
   `mem_receive_alarm` tinyint(4) default null,
   `mem_open_profile` tinyint(4) default null,
   `mem_receive_chat` tinyint(4) default null,
   `mem_email_cert` tinyint(4) default null,
   `mem_register_datetime` datetime default null,
   `mem_register_ip` varchar(20) default null,
   `mem_lastlogin_datetime` datetime default null,
   `mem_lastlogin_ip` varchar(20) default null,
   `mem_adminmemo` text default null,
   `mem_photo` varchar(20) default null,
   `mem_icon` varchar(20) default null,
   `mem_following` int(20) default null,
   `mem_followed` int(20) default null,
   `mem_denied` tinyint(4) default null,
   primary key(`mem_id`)
) engine=innodb default charset=utf8;

CREATE TABLE `board_group`(
    `bgr_id` int(11) default null,
    `bgr_key` varchar(20) default null,
    `bgr_name` varchar(20) default null,
    `bgr_order` int(20) default null
   primary key(`bgr_id`)
) engine=innodb default charset=utf8;

CREATE TABLE `board`(
    `brd_id` int(11) default null,
    `bgr_id` int(11) default null,
    `brd_key` varchar(20) default null,
    `brd_name` varchar(20) default null,
    `brd_mobile_name` varchar(20) default null,
    `brd_order` int(20) default null,
    `brd_search` varchar(20) default null
   primary key(`brd_id`)
) engine=innodb default charset=utf8;


CREATE TABLE `post`(
   `post_id` int(11) not null,
   `post_num` int(12) default null,
   `post_reply` varchar(20) default null,
   `brd_id` int(1024) default null,
   `post_title` varchar(20) default null,
   `post_content` varchar(20) default null,
   `post_category` varchar(20) default null,
   `mem_id` int(20) default null,
   `post_userid` varchar(4) not null,
   `post_username` varchar(4) default null,
   `post_nickname` varchar(4) default null,
   `post_email` varchar(4) default null,
   `post_image` text default null,
   `post_homepage` text(20) default null,
   `post_datetime` datetime default null,
   `post_password` varchar(20) default null,
   `post_updated_datetime` datetime default null,
   `post_update_mem_id` int(20) default null,
   `post_comment_count` int(20) default null,
   `post_comment_updated_datetime` datetime default null,
   `post_link_count` int(20) default null,
   `post_secret` tinyint(4) default null
   `post_notice` tinyint(4) default null
   `post_hit` int(10) default null
   `post_like` int(10) default null
   `post_dislike` int(10) default null
   --`ppo_id` int(10) default null
   `post_ip` varchar(20) default null
   `post_blame` int(10) default null
   `post_file` tinyint(4) default null
   `post_image` tinyint(4) default null
   `post_del` tinyint(4) default null
   `post_device` varchar(20) default null
   primary key(`post_id`)
) engine=innodb default charset=utf8;

create table `session`(
   `id` varchar(11) not null,
   `ip_address` varchar(20) default null,
   `timestamp` int(20) default null,
   `data` BLOB ,
   primary key(`id`)
) engine=innodb default charset=utf8;


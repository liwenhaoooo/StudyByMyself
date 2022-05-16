drop table if exists `chapter`;
create table `chapter` (
       `id` char(8) not null comment 'ID',
       `course_id` char(8) comment '课程ID',
       `name` varchar(50) comment '名称',
       primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='大章';

insert into `chapter` (id, course_id, name) values ('00000001', '00000001', '测试大章01');
insert into `chapter` (id, course_id, name) values ('00000002', '00000002', '测试大章02');
insert into `chapter` (id, course_id, name) values ('00000003', '00000000', '测试大章03');
insert into `chapter` (id, course_id, name) values ('00000004', '00000000', '测试大章04');
insert into `chapter` (id, course_id, name) values ('00000005', '00000000', '测试大章05');
insert into `chapter` (id, course_id, name) values ('00000006', '00000000', '测试大章06');
insert into `chapter` (id, course_id, name) values ('00000007', '00000000', '测试大章07');
insert into `chapter` (id, course_id, name) values ('00000008', '00000000', '测试大章08');
insert into `chapter` (id, course_id, name) values ('00000009', '00000000', '测试大章09');
insert into `chapter` (id, course_id, name) values ('00000010', '00000000', '测试大章10');
insert into `chapter` (id, course_id, name) values ('00000011', '00000000', '测试大章11');
insert into `chapter` (id, course_id, name) values ('00000012', '00000000', '测试大章12');
insert into `chapter` (id, course_id, name) values ('00000013', '00000000', '测试大章13');
insert into `chapter` (id, course_id, name) values ('00000014', '00000000', '测试大章14');
insert into `chapter` (id, course_id, name) values ('00000015', '00000000', '测试大章15');
insert into `chapter` (id, course_id, name) values ('00000016', '00000000', '测试大章16');
insert into `chapter` (id, course_id, name) values ('00000017', '00000000', '测试大章17');
insert into `chapter` (id, course_id, name) values ('00000018', '00000000', '测试大章18');
insert into `chapter` (id, course_id, name) values ('00000019', '00000000', '测试大章19');
insert into `chapter` (id, course_id, name) values ('00000020', '00000000', '测试大章20');
insert into `chapter` (id, course_id, name) values ('00000021', '00000000', '测试大章21');
insert into `chapter` (id, course_id, name) values ('00000022', '00000000', '测试大章22');
insert into `chapter` (id, course_id, name) values ('00000023', '00000000', '测试大章23');
insert into `chapter` (id, course_id, name) values ('00000024', '00000000', '测试大章24');
insert into `chapter` (id, course_id, name) values ('00000025', '00000000', '测试大章25');
insert into `chapter` (id, course_id, name) values ('00000026', '00000000', '测试大章26');
insert into `chapter` (id, course_id, name) values ('00000027', '00000000', '测试大章27');
insert into `chapter` (id, course_id, name) values ('00000028', '00000000', '测试大章28');
insert into `chapter` (id, course_id, name) values ('00000029', '00000000', '测试大章29');
insert into `chapter` (id, course_id, name) values ('00000030', '00000000', '测试大章30');

-- -------------------------------- test

drop table if exists `test`;
create table `test` (
    `id` char(8) not null default '' comment 'id',
    `name` varchar(50) comment '名称',
    primary key (`id`)
)engine = innodb default  charset=utf8mb4 comment ='测试';

insert into  `test` (`id`, `name`) value (1,'测试');
insert into  `test` (`id`, `name`) value (2,'测试');
insert into  `test` (`id`, `name`) value (3,'测试');
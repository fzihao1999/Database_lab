USE [master]
GO
/****** Object:  Database [201626810610MIS]    Script Date: 2020/6/9 0:25:41 ******/
CREATE DATABASE [201626810610MIS]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'201626810610MIS', FILENAME = N'D:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\201626810610MIS.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'201626810610MIS_log', FILENAME = N'D:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\201626810610MIS_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
 GO
create procedure Get_Rank
@course_id int,
@semester_id int
as
begin
	select * from [201626810610_scores] 
	where _201626810610_semester = @semester_id  and _201626810610_courseid = @course_id
	order by _201626810610_score
end
GO
create procedure Get_Ave_course
as
begin
	select _201626810610_courseid, AVG(_201626810610_score) as _201626810610_avescore
	from [201626810610_scores] group by _201626810610_courseid
end


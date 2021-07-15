USE [master]
GO
/****** Object:  Database [Adagawe]    Script Date: 7/15/2021 11:52:37 AM ******/
CREATE DATABASE [Adagawe]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Adagwe', FILENAME = N'D:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Adagwe.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Adagwe_log', FILENAME = N'D:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Adagwe_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Adagawe].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Adagawe] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Adagawe] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Adagawe] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Adagawe] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Adagawe] SET ARITHABORT OFF 
GO
ALTER DATABASE [Adagawe] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Adagawe] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Adagawe] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Adagawe] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Adagawe] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Adagawe] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Adagawe] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Adagawe] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Adagawe] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Adagawe] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Adagawe] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Adagawe] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Adagawe] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Adagawe] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Adagawe] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Adagawe] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Adagawe] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Adagawe] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Adagawe] SET  MULTI_USER 
GO
ALTER DATABASE [Adagawe] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Adagawe] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Adagawe] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Adagawe] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Adagawe] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Adagawe] SET QUERY_STORE = OFF
GO
USE [Adagawe]
GO
/****** Object:  Table [dbo].[Lamaran]    Script Date: 7/15/2021 11:52:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Lamaran](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_pelamar] [int] NULL,
	[id_lowongan] [int] NULL,
	[tanggal_melamar] [date] NULL,
	[pesan_pelamar] [varchar](255) NULL,
	[resume] [varchar](50) NULL,
	[status_lamaran] [int] NULL,
	[nilai_uji_kompetensi] [float] NULL,
	[nilai_wawancara] [float] NULL,
 CONSTRAINT [PK_Lamaran] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pendidikan]    Script Date: 7/15/2021 11:52:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pendidikan](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_pelamar] [int] NULL,
	[id_jenjang] [int] NULL,
	[nama_jurusan] [varchar](50) NULL,
	[nama_universitas] [varchar](100) NULL,
	[tahun_mulai] [varchar](10) NULL,
	[tahun_selesai] [varchar](10) NULL,
	[row_status] [int] NULL,
 CONSTRAINT [PK_Pendidikan] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Jenjang]    Script Date: 7/15/2021 11:52:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Jenjang](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nama_jenjang] [varchar](10) NULL,
	[deskripsi] [varchar](50) NULL,
	[tingkatan_jenjang] [float] NULL,
 CONSTRAINT [PK_Jenjang] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pelamar]    Script Date: 7/15/2021 11:52:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pelamar](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nama_pelamar] [varchar](100) NULL,
	[tanggal_lahir] [date] NULL,
	[jenis_kelamin] [char](1) NULL,
	[kota] [varchar](50) NULL,
	[alamat] [varchar](255) NULL,
	[no_telepon] [varchar](13) NULL,
	[headline] [varchar](100) NULL,
	[dokumen_cv] [varchar](100) NULL,
	[id_user_login] [int] NULL,
	[foto_profil] [varchar](100) NULL,
	[row_status] [int] NULL,
 CONSTRAINT [PK_Pelamar] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Lowongan]    Script Date: 7/15/2021 11:52:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Lowongan](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_perusahaan] [int] NULL,
	[id_jenis_pegawai] [int] NULL,
	[judul_lowongan] [varchar](100) NULL,
	[keterangan] [varchar](255) NULL,
	[jenjang_minimal] [int] NULL,
	[gaji_minimal] [int] NULL,
	[gaji_maksimal] [int] NULL,
	[pengalaman_kerja] [varchar](50) NULL,
	[keahlian] [varchar](255) NULL,
	[sembunyikan_gaji] [int] NULL,
	[status] [int] NULL,
	[created_date] [date] NULL,
	[last_modified] [date] NULL,
 CONSTRAINT [PK_Lowongan] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[view_LamaranPelamar]    Script Date: 7/15/2021 11:52:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[view_LamaranPelamar] AS

SELECT l.id AS id_lamaran, l.status_lamaran, l.id_lowongan, lo.jenjang_minimal, p.id, p.nama_pelamar, p.tanggal_lahir, p.jenis_kelamin, p.kota, p.alamat, p.no_telepon, p.headline, p.dokumen_cv, p.id_user_login, p.foto_profil, p.row_status, 
                         pt.pendidikan_terakhir, pt.tingkatan_jenjang, CAST(DATEDIFF(DD, p.tanggal_lahir, GETDATE()) / 365.25 AS INT) AS umur
FROM dbo.Lamaran AS l INNER JOIN dbo.Pelamar AS p ON l.id_pelamar = p.id JOIN Lowongan lo ON lo.id = l.id_lowongan LEFT OUTER JOIN
                             (SELECT p.id_pelamar, (SELECT nama_jenjang
                                                               FROM            dbo.Jenjang AS js
                                                               WHERE        (tingkatan_jenjang = MAX(j.tingkatan_jenjang))) AS pendidikan_terakhir,
															   (SELECT        tingkatan_jenjang
                                                               FROM            dbo.Jenjang AS js
                                                               WHERE        (tingkatan_jenjang = MAX(j.tingkatan_jenjang))) AS tingkatan_jenjang
                               FROM            dbo.Pendidikan AS p INNER JOIN
                                                         dbo.Jenjang AS j ON j.id = p.id_jenjang
                               GROUP BY p.id_pelamar) AS pt ON pt.id_pelamar = p.id
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 7/15/2021 11:52:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nama_admin] [varchar](100) NULL,
	[tanggal_lahir] [date] NULL,
	[jenis_kelamin] [char](1) NULL,
	[no_telepon] [varchar](13) NULL,
	[foto_profil] [varchar](100) NULL,
	[row_status] [int] NULL,
	[id_user_login] [int] NULL,
 CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ConfirmationToken]    Script Date: 7/15/2021 11:52:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ConfirmationToken](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_user] [int] NULL,
	[confirmation_token] [varchar](255) NULL,
	[created_date] [datetime] NULL,
 CONSTRAINT [PK_ConfirmationToken] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Jabatan]    Script Date: 7/15/2021 11:52:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Jabatan](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nama_jabatan] [varchar](50) NULL,
	[deskripsi] [varchar](255) NULL,
	[row_status] [int] NULL,
 CONSTRAINT [PK_Jabatan] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[JenisPegawai]    Script Date: 7/15/2021 11:52:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[JenisPegawai](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[jenis_pegawai] [varchar](100) NULL,
	[row_status] [int] NULL,
 CONSTRAINT [PK_JenisPegawai] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Notifikasi]    Script Date: 7/15/2021 11:52:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Notifikasi](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_lamaran] [int] NULL,
	[isi] [text] NOT NULL,
	[tahap] [int] NOT NULL,
	[tanggal_tahapan] [datetime] NOT NULL,
	[hasil_tahap_sebelumnya] [int] NOT NULL,
	[created_date] [datetime] NOT NULL,
 CONSTRAINT [PK_Notifikasi] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pengalaman]    Script Date: 7/15/2021 11:52:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pengalaman](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_pelamar] [int] NOT NULL,
	[id_jabatan] [int] NOT NULL,
	[id_jenis_pegawai] [int] NOT NULL,
	[nama_perusahaan] [varchar](100) NOT NULL,
	[mulai_kerja] [date] NOT NULL,
	[terakhir_kerja] [date] NOT NULL,
	[deskripsi] [varchar](255) NULL,
	[file_attachment] [varchar](100) NULL,
	[row_status] [int] NULL,
 CONSTRAINT [PK_Pengalaman] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Perusahaan]    Script Date: 7/15/2021 11:52:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Perusahaan](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nama_perusahaan] [varchar](100) NULL,
	[alamat_lengkap] [varchar](255) NULL,
	[provinsi] [varchar](50) NULL,
	[kota] [varchar](50) NULL,
	[telah_terverifikasi] [int] NULL,
	[foto_profil] [varchar](100) NULL,
	[bidang_perusahaan] [varchar](100) NULL,
	[row_status] [int] NULL,
	[id_user_login] [int] NULL,
 CONSTRAINT [PK_Perusahaan] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sertifikat]    Script Date: 7/15/2021 11:52:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sertifikat](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_pelamar] [int] NULL,
	[judul] [varchar](50) NULL,
	[no_sertifikat] [varchar](50) NULL,
	[berlaku_mulai] [date] NULL,
	[berlaku_sampai] [date] NULL,
	[file_attachment] [varchar](100) NULL,
	[row_status] [int] NULL,
 CONSTRAINT [PK_Sertifikat] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserLogin]    Script Date: 7/15/2021 11:52:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserLogin](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[email] [varchar](50) NULL,
	[password] [varchar](255) NULL,
	[user_role] [int] NULL,
	[locked] [int] NULL,
	[enabled] [int] NULL,
	[row_status] [int] NULL,
 CONSTRAINT [PK_UserLogin] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VerifikasiPerusahaan]    Script Date: 7/15/2021 11:52:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VerifikasiPerusahaan](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_perusahaan] [int] NULL,
	[npwp] [varchar](100) NULL,
	[tdp] [varchar](100) NULL,
	[siu] [varchar](100) NULL,
	[hasil] [int] NULL,
	[created_date] [date] NULL,
	[last_modified] [date] NULL,
	[diverifikasi_oleh] [varchar](50) NULL,
	[komentar] [varchar](100) NULL,
 CONSTRAINT [PK_VerifikasiPerusahaan] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Admin] ON 

INSERT [dbo].[Admin] ([id], [nama_admin], [tanggal_lahir], [jenis_kelamin], [no_telepon], [foto_profil], [row_status], [id_user_login]) VALUES (1, N'Mochammad Rifqy', CAST(N'2001-06-18' AS Date), N'L', N'089664467845', N'default-employee.jpg', 1, 1)
INSERT [dbo].[Admin] ([id], [nama_admin], [tanggal_lahir], [jenis_kelamin], [no_telepon], [foto_profil], [row_status], [id_user_login]) VALUES (2, N'Ivan Firmansyah', CAST(N'2021-06-24' AS Date), N'L', N'081245233455', N'default-employee.png', 1, 2)
INSERT [dbo].[Admin] ([id], [nama_admin], [tanggal_lahir], [jenis_kelamin], [no_telepon], [foto_profil], [row_status], [id_user_login]) VALUES (3, N'Rafli Mayori', CAST(N'2002-09-24' AS Date), N'L', N'082982387283', N'default-employee.png', 1, 3)
INSERT [dbo].[Admin] ([id], [nama_admin], [tanggal_lahir], [jenis_kelamin], [no_telepon], [foto_profil], [row_status], [id_user_login]) VALUES (4, N'Natasya Artamevia', CAST(N'2000-12-30' AS Date), N'P', N'082987382733', N'default-employee.png', 1, 4)
INSERT [dbo].[Admin] ([id], [nama_admin], [tanggal_lahir], [jenis_kelamin], [no_telepon], [foto_profil], [row_status], [id_user_login]) VALUES (5, N'Pujiati', CAST(N'2001-07-07' AS Date), N'P', N'083982392893', N'default-employee.png', 1, 5)
SET IDENTITY_INSERT [dbo].[Admin] OFF
GO
SET IDENTITY_INSERT [dbo].[ConfirmationToken] ON 

INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (1, 1, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-06-21T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (2, 2, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-06-21T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (3, 3, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-06-21T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (4, 4, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-06-21T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (5, 5, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-06-22T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (6, 6, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-06-24T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (7, 7, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-07-13T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (8, 8, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-07-13T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (9, 9, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-07-13T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (10, 10, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-07-13T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (11, 11, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-07-13T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (12, 12, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-07-13T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (13, 13, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-07-13T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (14, 14, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-07-13T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (15, 15, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-07-13T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (16, 16, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-07-13T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (17, 17, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-07-13T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (18, 18, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-07-13T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (19, 19, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-07-13T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (20, 20, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-07-13T00:00:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[ConfirmationToken] OFF
GO
SET IDENTITY_INSERT [dbo].[Jabatan] ON 

INSERT [dbo].[Jabatan] ([id], [nama_jabatan], [deskripsi], [row_status]) VALUES (1, N'Software Developer', NULL, 1)
INSERT [dbo].[Jabatan] ([id], [nama_jabatan], [deskripsi], [row_status]) VALUES (2, N'Database Administrator', NULL, 1)
INSERT [dbo].[Jabatan] ([id], [nama_jabatan], [deskripsi], [row_status]) VALUES (3, N'IT Support', NULL, 1)
INSERT [dbo].[Jabatan] ([id], [nama_jabatan], [deskripsi], [row_status]) VALUES (4, N'Senior Programmer', NULL, 1)
INSERT [dbo].[Jabatan] ([id], [nama_jabatan], [deskripsi], [row_status]) VALUES (5, N'System Analyst', NULL, 1)
INSERT [dbo].[Jabatan] ([id], [nama_jabatan], [deskripsi], [row_status]) VALUES (6, N'Network Architect', NULL, 1)
INSERT [dbo].[Jabatan] ([id], [nama_jabatan], [deskripsi], [row_status]) VALUES (7, N'Web Developer', NULL, 1)
INSERT [dbo].[Jabatan] ([id], [nama_jabatan], [deskripsi], [row_status]) VALUES (8, N'UI/UX Designer', NULL, 1)
INSERT [dbo].[Jabatan] ([id], [nama_jabatan], [deskripsi], [row_status]) VALUES (9, N'Data Scientist', NULL, 1)
INSERT [dbo].[Jabatan] ([id], [nama_jabatan], [deskripsi], [row_status]) VALUES (10, N'Junior Programmer', NULL, 1)
SET IDENTITY_INSERT [dbo].[Jabatan] OFF
GO
SET IDENTITY_INSERT [dbo].[JenisPegawai] ON 

INSERT [dbo].[JenisPegawai] ([id], [jenis_pegawai], [row_status]) VALUES (1, N'Full-time', 1)
INSERT [dbo].[JenisPegawai] ([id], [jenis_pegawai], [row_status]) VALUES (2, N'Part-time', 1)
INSERT [dbo].[JenisPegawai] ([id], [jenis_pegawai], [row_status]) VALUES (3, N'Freelance', 1)
INSERT [dbo].[JenisPegawai] ([id], [jenis_pegawai], [row_status]) VALUES (4, N'Contract', 1)
INSERT [dbo].[JenisPegawai] ([id], [jenis_pegawai], [row_status]) VALUES (5, N'Magang', 1)
SET IDENTITY_INSERT [dbo].[JenisPegawai] OFF
GO
SET IDENTITY_INSERT [dbo].[Jenjang] ON 

INSERT [dbo].[Jenjang] ([id], [nama_jenjang], [deskripsi], [tingkatan_jenjang]) VALUES (1, N'SD', N'Sekolah Dasar', 1)
INSERT [dbo].[Jenjang] ([id], [nama_jenjang], [deskripsi], [tingkatan_jenjang]) VALUES (2, N'SMP', N'Sekolah Menengah Pertama', 2)
INSERT [dbo].[Jenjang] ([id], [nama_jenjang], [deskripsi], [tingkatan_jenjang]) VALUES (3, N'SMK', N'Sekolah Menengah Kejurusan', 3)
INSERT [dbo].[Jenjang] ([id], [nama_jenjang], [deskripsi], [tingkatan_jenjang]) VALUES (4, N'SMA', N'Sekolah Menengah Atas', 3.5)
INSERT [dbo].[Jenjang] ([id], [nama_jenjang], [deskripsi], [tingkatan_jenjang]) VALUES (5, N'D3', N'Diploma III', 4)
INSERT [dbo].[Jenjang] ([id], [nama_jenjang], [deskripsi], [tingkatan_jenjang]) VALUES (6, N'D4', N'Diplova IV', 5)
INSERT [dbo].[Jenjang] ([id], [nama_jenjang], [deskripsi], [tingkatan_jenjang]) VALUES (7, N'S1', N'Sarjana', 5.5)
INSERT [dbo].[Jenjang] ([id], [nama_jenjang], [deskripsi], [tingkatan_jenjang]) VALUES (8, N'S2', N'Magister', 6)
INSERT [dbo].[Jenjang] ([id], [nama_jenjang], [deskripsi], [tingkatan_jenjang]) VALUES (9, N'S3', N'Doctor', 7)
SET IDENTITY_INSERT [dbo].[Jenjang] OFF
GO
SET IDENTITY_INSERT [dbo].[Lamaran] ON 

INSERT [dbo].[Lamaran] ([id], [id_pelamar], [id_lowongan], [tanggal_melamar], [pesan_pelamar], [resume], [status_lamaran], [nilai_uji_kompetensi], [nilai_wawancara]) VALUES (1, 1, 1, CAST(N'2021-07-13' AS Date), N'Saya berpenampilan baik dan pantang menyerah', NULL, 0, NULL, NULL)
INSERT [dbo].[Lamaran] ([id], [id_pelamar], [id_lowongan], [tanggal_melamar], [pesan_pelamar], [resume], [status_lamaran], [nilai_uji_kompetensi], [nilai_wawancara]) VALUES (2, 3, 2, CAST(N'2021-07-14' AS Date), N'Saya ingin melamar di perusahaan anda', N'140721-055313-895.pdf', 2, NULL, NULL)
INSERT [dbo].[Lamaran] ([id], [id_pelamar], [id_lowongan], [tanggal_melamar], [pesan_pelamar], [resume], [status_lamaran], [nilai_uji_kompetensi], [nilai_wawancara]) VALUES (3, 6, 1, CAST(N'2021-07-13' AS Date), N'Saya memiliki kemampuan kerjasama tim yang baik', NULL, 2, NULL, NULL)
INSERT [dbo].[Lamaran] ([id], [id_pelamar], [id_lowongan], [tanggal_melamar], [pesan_pelamar], [resume], [status_lamaran], [nilai_uji_kompetensi], [nilai_wawancara]) VALUES (4, 4, 1, CAST(N'2021-07-13' AS Date), N'Saya berpenampilan baik dan pantang menyerah', NULL, 3, NULL, NULL)
INSERT [dbo].[Lamaran] ([id], [id_pelamar], [id_lowongan], [tanggal_melamar], [pesan_pelamar], [resume], [status_lamaran], [nilai_uji_kompetensi], [nilai_wawancara]) VALUES (5, 7, 1, CAST(N'2021-07-13' AS Date), N'Saya memiliki kemampuan kerjasama tim yang baik', NULL, 0, NULL, NULL)
INSERT [dbo].[Lamaran] ([id], [id_pelamar], [id_lowongan], [tanggal_melamar], [pesan_pelamar], [resume], [status_lamaran], [nilai_uji_kompetensi], [nilai_wawancara]) VALUES (6, 1, 2, CAST(N'2021-07-13' AS Date), N'Saya berpenampilan baik dan pantang menyerah', NULL, 5, NULL, NULL)
INSERT [dbo].[Lamaran] ([id], [id_pelamar], [id_lowongan], [tanggal_melamar], [pesan_pelamar], [resume], [status_lamaran], [nilai_uji_kompetensi], [nilai_wawancara]) VALUES (7, 2, 2, CAST(N'2021-07-13' AS Date), N'Saya memiliki kemampuan kerjasama tim yang baik', NULL, 2, NULL, NULL)
INSERT [dbo].[Lamaran] ([id], [id_pelamar], [id_lowongan], [tanggal_melamar], [pesan_pelamar], [resume], [status_lamaran], [nilai_uji_kompetensi], [nilai_wawancara]) VALUES (9, 4, 2, CAST(N'2021-07-13' AS Date), N'Saya berpenampilan baik dan pantang menyerah', NULL, 1, NULL, NULL)
INSERT [dbo].[Lamaran] ([id], [id_pelamar], [id_lowongan], [tanggal_melamar], [pesan_pelamar], [resume], [status_lamaran], [nilai_uji_kompetensi], [nilai_wawancara]) VALUES (10, 5, 2, CAST(N'2021-07-13' AS Date), N'Saya memiliki kemampuan kerjasama tim yang baik', NULL, 1, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Lamaran] OFF
GO
SET IDENTITY_INSERT [dbo].[Lowongan] ON 

INSERT [dbo].[Lowongan] ([id], [id_perusahaan], [id_jenis_pegawai], [judul_lowongan], [keterangan], [jenjang_minimal], [gaji_minimal], [gaji_maksimal], [pengalaman_kerja], [keahlian], [sembunyikan_gaji], [status], [created_date], [last_modified]) VALUES (1, 1, 1, N'Front-End Developer', N'asdasd', 3, 5000000, 10000000, N'1 - 3 tahun', N'Spring, Laravel, React.js', 0, 1, CAST(N'2021-06-30' AS Date), CAST(N'2021-07-02' AS Date))
INSERT [dbo].[Lowongan] ([id], [id_perusahaan], [id_jenis_pegawai], [judul_lowongan], [keterangan], [jenjang_minimal], [gaji_minimal], [gaji_maksimal], [pengalaman_kerja], [keahlian], [sembunyikan_gaji], [status], [created_date], [last_modified]) VALUES (2, 2, 2, N'Back-End Developer', N'asdasd', 5, 6000000, 9000000, N'< 1 tahun', N'Node.js, Lumen', 0, 1, CAST(N'2021-06-30' AS Date), CAST(N'2021-07-02' AS Date))
INSERT [dbo].[Lowongan] ([id], [id_perusahaan], [id_jenis_pegawai], [judul_lowongan], [keterangan], [jenjang_minimal], [gaji_minimal], [gaji_maksimal], [pengalaman_kerja], [keahlian], [sembunyikan_gaji], [status], [created_date], [last_modified]) VALUES (3, 1, 3, N'Data Science', N'asdfghjkl', 4, 12000, 15000, N'3 tahun', N'SQL, R, Phyton', 0, 1, CAST(N'2021-07-07' AS Date), CAST(N'2021-07-02' AS Date))
INSERT [dbo].[Lowongan] ([id], [id_perusahaan], [id_jenis_pegawai], [judul_lowongan], [keterangan], [jenjang_minimal], [gaji_minimal], [gaji_maksimal], [pengalaman_kerja], [keahlian], [sembunyikan_gaji], [status], [created_date], [last_modified]) VALUES (4, 4, 1, N'Junior Programmer', N'minimal pendidikan D3', 4, 5000000, 4000000, N'1 - 5 tahun', N'React.js', 0, 1, CAST(N'2021-07-13' AS Date), CAST(N'2021-07-13' AS Date))
INSERT [dbo].[Lowongan] ([id], [id_perusahaan], [id_jenis_pegawai], [judul_lowongan], [keterangan], [jenjang_minimal], [gaji_minimal], [gaji_maksimal], [pengalaman_kerja], [keahlian], [sembunyikan_gaji], [status], [created_date], [last_modified]) VALUES (5, 5, 2, N'System Analyst', N'pengalaman kerja min 2 tahun', 5, 4000000, 6000000, N'> 5 tahun', N'Vue.js', 0, 1, CAST(N'2021-07-13' AS Date), CAST(N'2021-07-13' AS Date))
INSERT [dbo].[Lowongan] ([id], [id_perusahaan], [id_jenis_pegawai], [judul_lowongan], [keterangan], [jenjang_minimal], [gaji_minimal], [gaji_maksimal], [pengalaman_kerja], [keahlian], [sembunyikan_gaji], [status], [created_date], [last_modified]) VALUES (6, 6, 3, N'Junior Programmer', N'minimal pendidikan D3', 3, 3000000, 5000000, N'< 2 tahun', N'MongoDB, Node.js', 0, 1, CAST(N'2021-07-13' AS Date), CAST(N'2021-07-13' AS Date))
INSERT [dbo].[Lowongan] ([id], [id_perusahaan], [id_jenis_pegawai], [judul_lowongan], [keterangan], [jenjang_minimal], [gaji_minimal], [gaji_maksimal], [pengalaman_kerja], [keahlian], [sembunyikan_gaji], [status], [created_date], [last_modified]) VALUES (7, 7, 4, N'System Analyst', N'fresh graduate', 5, 5000000, 4000000, N'> 1 tahun', N'Adobe Photoshop, Adobe Illustrator', 0, 1, CAST(N'2021-07-13' AS Date), CAST(N'2021-07-13' AS Date))
INSERT [dbo].[Lowongan] ([id], [id_perusahaan], [id_jenis_pegawai], [judul_lowongan], [keterangan], [jenjang_minimal], [gaji_minimal], [gaji_maksimal], [pengalaman_kerja], [keahlian], [sembunyikan_gaji], [status], [created_date], [last_modified]) VALUES (8, 8, 5, N'Junior Programmer', N'minimal pendidikan D3', 5, 4000000, 5000000, N'1 - 5 tahun', N'Adobe XD', 0, 1, CAST(N'2021-07-13' AS Date), CAST(N'2021-07-13' AS Date))
INSERT [dbo].[Lowongan] ([id], [id_perusahaan], [id_jenis_pegawai], [judul_lowongan], [keterangan], [jenjang_minimal], [gaji_minimal], [gaji_maksimal], [pengalaman_kerja], [keahlian], [sembunyikan_gaji], [status], [created_date], [last_modified]) VALUES (9, 9, 1, N'System Analyst', N'pengalaman kerja min 2 tahun', 6, 5000000, 6000000, N'1 - 3 tahun', N'Javascript, SCSS', 0, 1, CAST(N'2021-07-13' AS Date), CAST(N'2021-07-13' AS Date))
INSERT [dbo].[Lowongan] ([id], [id_perusahaan], [id_jenis_pegawai], [judul_lowongan], [keterangan], [jenjang_minimal], [gaji_minimal], [gaji_maksimal], [pengalaman_kerja], [keahlian], [sembunyikan_gaji], [status], [created_date], [last_modified]) VALUES (10, 10, 2, N'System Analyst', N'pengalaman kerja min 2 tahun', 3, 3000000, 5000000, N'> 5', N'CSS, HTML', 0, 1, CAST(N'2021-07-13' AS Date), CAST(N'2021-07-13' AS Date))
SET IDENTITY_INSERT [dbo].[Lowongan] OFF
GO
SET IDENTITY_INSERT [dbo].[Pelamar] ON 

INSERT [dbo].[Pelamar] ([id], [nama_pelamar], [tanggal_lahir], [jenis_kelamin], [kota], [alamat], [no_telepon], [headline], [dokumen_cv], [id_user_login], [foto_profil], [row_status]) VALUES (1, N'Samodra', CAST(N'2021-06-25' AS Date), N'L', N'Ponorogo', N'Trisono', N'082380535032', NULL, NULL, 6, N'default-employee.png', 0)
INSERT [dbo].[Pelamar] ([id], [nama_pelamar], [tanggal_lahir], [jenis_kelamin], [kota], [alamat], [no_telepon], [headline], [dokumen_cv], [id_user_login], [foto_profil], [row_status]) VALUES (2, N'Satria Adjie', CAST(N'2001-06-24' AS Date), N'L', N'Jakarta', N'Kp. Rambutan', N'083647364736', NULL, NULL, 7, N'default-employee.png', 0)
INSERT [dbo].[Pelamar] ([id], [nama_pelamar], [tanggal_lahir], [jenis_kelamin], [kota], [alamat], [no_telepon], [headline], [dokumen_cv], [id_user_login], [foto_profil], [row_status]) VALUES (3, N'Salsabila Khroinsin', CAST(N'2001-06-01' AS Date), N'P', N'Jakarta', N'Jaksel', N'089392788438', NULL, NULL, 8, N'default-employee.png', 0)
INSERT [dbo].[Pelamar] ([id], [nama_pelamar], [tanggal_lahir], [jenis_kelamin], [kota], [alamat], [no_telepon], [headline], [dokumen_cv], [id_user_login], [foto_profil], [row_status]) VALUES (4, N'Fayza Nurrahmi', CAST(N'2001-02-25' AS Date), N'P', N'Bekasi', N'Jatiasih', N'089274848738', NULL, NULL, 9, N'default-employee.png', 0)
INSERT [dbo].[Pelamar] ([id], [nama_pelamar], [tanggal_lahir], [jenis_kelamin], [kota], [alamat], [no_telepon], [headline], [dokumen_cv], [id_user_login], [foto_profil], [row_status]) VALUES (5, N'Fikri Adriansyah', CAST(N'2001-03-25' AS Date), N'L', N'Sukabumi', N'Sb', N'082322434545', NULL, NULL, 10, N'default-employee.png', 0)
INSERT [dbo].[Pelamar] ([id], [nama_pelamar], [tanggal_lahir], [jenis_kelamin], [kota], [alamat], [no_telepon], [headline], [dokumen_cv], [id_user_login], [foto_profil], [row_status]) VALUES (6, N'Fiorenta', CAST(N'2001-06-06' AS Date), N'L', N'Jakarta', N'Cilincing', N'084734873874', NULL, NULL, 16, N'default-employee.png', 0)
INSERT [dbo].[Pelamar] ([id], [nama_pelamar], [tanggal_lahir], [jenis_kelamin], [kota], [alamat], [no_telepon], [headline], [dokumen_cv], [id_user_login], [foto_profil], [row_status]) VALUES (7, N'Firda', CAST(N'2002-06-25' AS Date), N'P', N'Bekasi', N'Bk', N'089483748374', NULL, NULL, 17, N'default-employee.png', 0)
INSERT [dbo].[Pelamar] ([id], [nama_pelamar], [tanggal_lahir], [jenis_kelamin], [kota], [alamat], [no_telepon], [headline], [dokumen_cv], [id_user_login], [foto_profil], [row_status]) VALUES (8, N'Habibah', CAST(N'2001-11-25' AS Date), N'P', N'Nganjuk', N'ng', N'082323248888', NULL, NULL, NULL, N'default-employee.png', 0)
INSERT [dbo].[Pelamar] ([id], [nama_pelamar], [tanggal_lahir], [jenis_kelamin], [kota], [alamat], [no_telepon], [headline], [dokumen_cv], [id_user_login], [foto_profil], [row_status]) VALUES (9, N'Harvianti', CAST(N'2001-12-25' AS Date), N'P', N'Bekasi', N'Bk', N'089323289483', NULL, NULL, NULL, N'default-employee.png', 0)
INSERT [dbo].[Pelamar] ([id], [nama_pelamar], [tanggal_lahir], [jenis_kelamin], [kota], [alamat], [no_telepon], [headline], [dokumen_cv], [id_user_login], [foto_profil], [row_status]) VALUES (10, N'Kinanti', CAST(N'2001-06-14' AS Date), N'P', N'Surabaya', N'Sby', N'089284772637', NULL, NULL, NULL, N'default-employee.png', 0)
INSERT [dbo].[Pelamar] ([id], [nama_pelamar], [tanggal_lahir], [jenis_kelamin], [kota], [alamat], [no_telepon], [headline], [dokumen_cv], [id_user_login], [foto_profil], [row_status]) VALUES (11, N'Reza', CAST(N'2000-02-02' AS Date), N'L', N'Bekasi', N'Bk', N'083928392732', NULL, NULL, NULL, N'default-employee.png', 0)
SET IDENTITY_INSERT [dbo].[Pelamar] OFF
GO
SET IDENTITY_INSERT [dbo].[Pendidikan] ON 

INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (1, 1, 5, N'Sistem Informasi', N'Politeknik Astra International', N'2015', N'2019', 1)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (2, 1, 7, N'Teknik Informatika', N'Universitas Binus', N'2019', N'2021', 1)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (3, 1, 8, N'Teknik Informatika', N'Universitas Indonesia', N'2022', N'2025', 1)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (4, 1, 8, N'Teknik Informatika', N'Universitas Binus', N'2022', N'2025', 0)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (5, 1, 5, N'Sistem Informasi', N'Politeknik Negeri Jakarta', N'2015', N'2018', 1)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (6, 2, 7, N'Ilmu Komputer', N'Universitas Indonesia', N'2018', N'2020', 1)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (7, 2, 6, N'Manajemen Informatika', N'Politeknik Sriwijaya', N'2017', N'2021', 1)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (8, 2, 7, N'Ilmu Komputer', N'Universitas Mercubuana', N'2015', N'2019', 1)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (9, 2, 5, N'Sistem Informasi', N'Politeknik Negeri Jakarta', N'2014', N'2017', 1)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (10, 2, 7, N'Ilmu Komputer', N'Universitas Mercubuana', N'2018', N'2020', 1)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (11, 3, 7, N'Sistem Informasi', N'Universitas Indonesia', N'2016', N'2020', 1)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (12, 3, 6, N'Manajemen Informatika', N'Politeknik Negeri Jakarta', N'2015', N'2019', 1)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (13, 3, 7, N'Sistem Informasi', N'Universitas Mercubuana', N'2017', N'2021', 1)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (14, 3, 7, N'Sistem Informasi', N'Universitas Indonesia', N'2016', N'2020', 1)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (15, 4, 3, N'RPL', N'SMKN 1 Ponorogo', N'2016', N'2019', 1)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (16, 5, 3, N'Akuntansi', N'SMKN 1 Madiun', N'2016', N'2019', 1)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (17, 6, 4, N'IPA', N'SMAN 1 Jakarta', N'2016', N'2019', 1)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (18, 7, 4, N'IPA', N'MAN 2 Bekasi', N'2016', N'2019', NULL)
SET IDENTITY_INSERT [dbo].[Pendidikan] OFF
GO
SET IDENTITY_INSERT [dbo].[Pengalaman] ON 

INSERT [dbo].[Pengalaman] ([id], [id_pelamar], [id_jabatan], [id_jenis_pegawai], [nama_perusahaan], [mulai_kerja], [terakhir_kerja], [deskripsi], [file_attachment], [row_status]) VALUES (1, 1, 1, 2, N'BlueBird Indonesian', CAST(N'2021-06-22' AS Date), CAST(N'2021-08-17' AS Date), NULL, NULL, 0)
INSERT [dbo].[Pengalaman] ([id], [id_pelamar], [id_jabatan], [id_jenis_pegawai], [nama_perusahaan], [mulai_kerja], [terakhir_kerja], [deskripsi], [file_attachment], [row_status]) VALUES (2, 1, 6, 1, N'Google Indonesia', CAST(N'2021-08-22' AS Date), CAST(N'2021-10-22' AS Date), NULL, NULL, 1)
INSERT [dbo].[Pengalaman] ([id], [id_pelamar], [id_jabatan], [id_jenis_pegawai], [nama_perusahaan], [mulai_kerja], [terakhir_kerja], [deskripsi], [file_attachment], [row_status]) VALUES (3, 1, 1, 3, N'GOJEK', CAST(N'2021-06-24' AS Date), CAST(N'2021-06-25' AS Date), NULL, NULL, 1)
INSERT [dbo].[Pengalaman] ([id], [id_pelamar], [id_jabatan], [id_jenis_pegawai], [nama_perusahaan], [mulai_kerja], [terakhir_kerja], [deskripsi], [file_attachment], [row_status]) VALUES (4, 1, 1, 1, N'BlueBird Indonesian', CAST(N'2021-06-23' AS Date), CAST(N'2021-06-23' AS Date), NULL, NULL, 1)
INSERT [dbo].[Pengalaman] ([id], [id_pelamar], [id_jabatan], [id_jenis_pegawai], [nama_perusahaan], [mulai_kerja], [terakhir_kerja], [deskripsi], [file_attachment], [row_status]) VALUES (5, 4, 3, 4, N'AstraLife', CAST(N'2018-02-02' AS Date), CAST(N'2020-02-02' AS Date), NULL, N'default.jpg', 0)
INSERT [dbo].[Pengalaman] ([id], [id_pelamar], [id_jabatan], [id_jenis_pegawai], [nama_perusahaan], [mulai_kerja], [terakhir_kerja], [deskripsi], [file_attachment], [row_status]) VALUES (6, 5, 3, 1, N'Astra Internasional', CAST(N'2019-01-01' AS Date), CAST(N'2021-01-01' AS Date), NULL, N'default.jpg', 0)
INSERT [dbo].[Pengalaman] ([id], [id_pelamar], [id_jabatan], [id_jenis_pegawai], [nama_perusahaan], [mulai_kerja], [terakhir_kerja], [deskripsi], [file_attachment], [row_status]) VALUES (7, 6, 2, 1, N'PT Paros Indonesia', CAST(N'2018-03-02' AS Date), CAST(N'2021-02-03' AS Date), NULL, N'default.jpg', 0)
INSERT [dbo].[Pengalaman] ([id], [id_pelamar], [id_jabatan], [id_jenis_pegawai], [nama_perusahaan], [mulai_kerja], [terakhir_kerja], [deskripsi], [file_attachment], [row_status]) VALUES (8, 7, 1, 4, N'PT United Tractor', CAST(N'2019-03-02' AS Date), CAST(N'2021-03-02' AS Date), NULL, N'default.jpg', 0)
INSERT [dbo].[Pengalaman] ([id], [id_pelamar], [id_jabatan], [id_jenis_pegawai], [nama_perusahaan], [mulai_kerja], [terakhir_kerja], [deskripsi], [file_attachment], [row_status]) VALUES (9, 8, 2, 2, N'PT Persero Indonesia', CAST(N'2018-01-03' AS Date), CAST(N'2020-01-03' AS Date), NULL, N'default.jpg', 0)
INSERT [dbo].[Pengalaman] ([id], [id_pelamar], [id_jabatan], [id_jenis_pegawai], [nama_perusahaan], [mulai_kerja], [terakhir_kerja], [deskripsi], [file_attachment], [row_status]) VALUES (10, 9, 4, 2, N'PT Awi Cikarang', CAST(N'2019-02-02' AS Date), CAST(N'2021-02-02' AS Date), NULL, N'default.jpg', 0)
INSERT [dbo].[Pengalaman] ([id], [id_pelamar], [id_jabatan], [id_jenis_pegawai], [nama_perusahaan], [mulai_kerja], [terakhir_kerja], [deskripsi], [file_attachment], [row_status]) VALUES (11, 10, 2, 1, N'PT Sentosa Berjaya', CAST(N'2017-09-09' AS Date), CAST(N'2020-09-09' AS Date), NULL, N'default.jpg', 0)
SET IDENTITY_INSERT [dbo].[Pengalaman] OFF
GO
SET IDENTITY_INSERT [dbo].[Perusahaan] ON 

INSERT [dbo].[Perusahaan] ([id], [nama_perusahaan], [alamat_lengkap], [provinsi], [kota], [telah_terverifikasi], [foto_profil], [bidang_perusahaan], [row_status], [id_user_login]) VALUES (1, N'Tokopedia', N'Jl. Dummy', N'Jakarta', N'Jakarta Utara', 1, N'default-company.png', N'Startup IT', 0, 11)
INSERT [dbo].[Perusahaan] ([id], [nama_perusahaan], [alamat_lengkap], [provinsi], [kota], [telah_terverifikasi], [foto_profil], [bidang_perusahaan], [row_status], [id_user_login]) VALUES (2, N'PT Astra Graphia Information Technology', N'Jl. Dummy', N'Jakarta', N'Jakarta Utara', 1, N'default-company.png', N'Computer Networking', 0, 12)
INSERT [dbo].[Perusahaan] ([id], [nama_perusahaan], [alamat_lengkap], [provinsi], [kota], [telah_terverifikasi], [foto_profil], [bidang_perusahaan], [row_status], [id_user_login]) VALUES (3, N'Babel Farma', N'Jl. Simatupang', N'Jawa Barat', N'Bekasi', 1, N'default-company.png', N'Properti', 0, 13)
INSERT [dbo].[Perusahaan] ([id], [nama_perusahaan], [alamat_lengkap], [provinsi], [kota], [telah_terverifikasi], [foto_profil], [bidang_perusahaan], [row_status], [id_user_login]) VALUES (4, N'Astra Life', N'Jl. Kebayoran Lama III', N'Jawa Barat', N'Tambun', 1, N'default-company.png', N'Kosmetik', 0, 14)
INSERT [dbo].[Perusahaan] ([id], [nama_perusahaan], [alamat_lengkap], [provinsi], [kota], [telah_terverifikasi], [foto_profil], [bidang_perusahaan], [row_status], [id_user_login]) VALUES (5, N'Ciputat Green', N'Jl. Kembalilah', N'Jawa Barat', N'Cikarang', 1, N'default-company.png', N'Farmasi', 0, 15)
INSERT [dbo].[Perusahaan] ([id], [nama_perusahaan], [alamat_lengkap], [provinsi], [kota], [telah_terverifikasi], [foto_profil], [bidang_perusahaan], [row_status], [id_user_login]) VALUES (6, N'Weezly', N'Jl. Pulang', N'Jawa Barat', N'Karawang', 0, N'default-company.png', N'Makanan', 0, NULL)
INSERT [dbo].[Perusahaan] ([id], [nama_perusahaan], [alamat_lengkap], [provinsi], [kota], [telah_terverifikasi], [foto_profil], [bidang_perusahaan], [row_status], [id_user_login]) VALUES (7, N'Growithu', N'Jl. Kenangan 2', N'Jawa Barat', N'Serang', 0, N'default-company.png', N'Makanan Ringan', 0, NULL)
INSERT [dbo].[Perusahaan] ([id], [nama_perusahaan], [alamat_lengkap], [provinsi], [kota], [telah_terverifikasi], [foto_profil], [bidang_perusahaan], [row_status], [id_user_login]) VALUES (8, N'Samsan Tech', N'Jl. samundong', N'Jawa Barat', N'Tangerang Selatan', 0, N'default-company.png', N'Minuman ', 0, NULL)
INSERT [dbo].[Perusahaan] ([id], [nama_perusahaan], [alamat_lengkap], [provinsi], [kota], [telah_terverifikasi], [foto_profil], [bidang_perusahaan], [row_status], [id_user_login]) VALUES (9, N'Ajaib', N'Jl. Prada', N'Jawa Barat', N'Bogor', 0, N'default-company.png', N'Makanan', 0, NULL)
INSERT [dbo].[Perusahaan] ([id], [nama_perusahaan], [alamat_lengkap], [provinsi], [kota], [telah_terverifikasi], [foto_profil], [bidang_perusahaan], [row_status], [id_user_login]) VALUES (10, N'Pure Company', N'Jl. Ciputat Raya', N'Jawa Barat', N'Depok', 0, N'default-company.png', N'IT', 0, NULL)
SET IDENTITY_INSERT [dbo].[Perusahaan] OFF
GO
SET IDENTITY_INSERT [dbo].[Sertifikat] ON 

INSERT [dbo].[Sertifikat] ([id], [id_pelamar], [judul], [no_sertifikat], [berlaku_mulai], [berlaku_sampai], [file_attachment], [row_status]) VALUES (1, 1, N'Fundamental Programming Beginner', N'2001-2021', CAST(N'2014-06-18' AS Date), CAST(N'2018-06-18' AS Date), N'fsdfdsfdsgdgdfgfg', 1)
INSERT [dbo].[Sertifikat] ([id], [id_pelamar], [judul], [no_sertifikat], [berlaku_mulai], [berlaku_sampai], [file_attachment], [row_status]) VALUES (2, 1, N'Fundamental Programming Beginner', N'2001-2021', CAST(N'2014-06-18' AS Date), CAST(N'2018-06-18' AS Date), N'fsdfdsfdsgdgdfgfg', 1)
INSERT [dbo].[Sertifikat] ([id], [id_pelamar], [judul], [no_sertifikat], [berlaku_mulai], [berlaku_sampai], [file_attachment], [row_status]) VALUES (3, 1, N'Fundamental Programming Expertz', N'1431-1233e343', CAST(N'2021-06-23' AS Date), CAST(N'2024-06-23' AS Date), N'asddsfdsgdfgdf', 1)
INSERT [dbo].[Sertifikat] ([id], [id_pelamar], [judul], [no_sertifikat], [berlaku_mulai], [berlaku_sampai], [file_attachment], [row_status]) VALUES (4, 2, N'Fundamental Programming Expertfd', N'2001-2021', CAST(N'2021-06-23' AS Date), CAST(N'2021-06-23' AS Date), N'asddsfdsgdfgdf', 0)
INSERT [dbo].[Sertifikat] ([id], [id_pelamar], [judul], [no_sertifikat], [berlaku_mulai], [berlaku_sampai], [file_attachment], [row_status]) VALUES (5, 2, N'Fundamental Programming Beginner', N'1431-1233e87h', CAST(N'2021-06-08' AS Date), CAST(N'2024-06-08' AS Date), N'070721-025255-333.pdf', 0)
INSERT [dbo].[Sertifikat] ([id], [id_pelamar], [judul], [no_sertifikat], [berlaku_mulai], [berlaku_sampai], [file_attachment], [row_status]) VALUES (6, 2, N'Fundamental Programming Beginner', N'1283-1233e398', CAST(N'2021-08-03' AS Date), CAST(N'2024-08-03' AS Date), N'070721-025255-333.pdf', 0)
INSERT [dbo].[Sertifikat] ([id], [id_pelamar], [judul], [no_sertifikat], [berlaku_mulai], [berlaku_sampai], [file_attachment], [row_status]) VALUES (7, 3, N'Fundamental Programming Beginner', N'1452-1233e343', CAST(N'2021-05-09' AS Date), CAST(N'2024-05-09' AS Date), N'070721-025255-333.pdf', 0)
INSERT [dbo].[Sertifikat] ([id], [id_pelamar], [judul], [no_sertifikat], [berlaku_mulai], [berlaku_sampai], [file_attachment], [row_status]) VALUES (8, 3, N'Fundamental Programming Beginner', N'1431-1233e312', CAST(N'2021-01-08' AS Date), CAST(N'2024-01-08' AS Date), N'070721-025255-333.pdf', 0)
INSERT [dbo].[Sertifikat] ([id], [id_pelamar], [judul], [no_sertifikat], [berlaku_mulai], [berlaku_sampai], [file_attachment], [row_status]) VALUES (9, 3, N'Fundamental Programming Expert', N'1878-1233e347', CAST(N'2021-06-08' AS Date), CAST(N'2024-06-08' AS Date), N'070721-025255-333.pdf', 0)
INSERT [dbo].[Sertifikat] ([id], [id_pelamar], [judul], [no_sertifikat], [berlaku_mulai], [berlaku_sampai], [file_attachment], [row_status]) VALUES (10, 4, N'Fundamental Programming Beginner', N'1772-1233e343', CAST(N'2021-04-09' AS Date), CAST(N'2024-04-09' AS Date), N'070721-025255-333.pdf', 0)
INSERT [dbo].[Sertifikat] ([id], [id_pelamar], [judul], [no_sertifikat], [berlaku_mulai], [berlaku_sampai], [file_attachment], [row_status]) VALUES (11, 4, N'Fundamental Programming Beginner', N'1088-1233e399', CAST(N'2021-05-11' AS Date), CAST(N'2024-05-11' AS Date), N'070721-025255-333.pdf', 0)
SET IDENTITY_INSERT [dbo].[Sertifikat] OFF
GO
SET IDENTITY_INSERT [dbo].[UserLogin] ON 

INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (1, N'muhrifh@gmail.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 0, 0, 1, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (2, N'ivanmansyah@gmail.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 0, 0, 1, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (3, N'rafli.mayori@gmail.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 0, 0, 1, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (4, N'natasya@gmail.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 0, 0, 1, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (5, N'suwandi@gmail.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 0, 0, 1, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (6, N'samodra.me@gmail.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 1, 0, 1, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (7, N'satria.adjie@gmail.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 1, 0, 1, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (8, N'salsabila@gmail.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 1, 0, 1, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (9, N'fayza.nur@gmail.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 1, 0, 1, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (10, N'fikri.adr@gmail.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 1, 0, 1, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (11, N'hrd@tokopedia.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 2, 0, 1, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (12, N'hrd@agit.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 2, 0, 1, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (13, N'hrd@babel.farma.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 2, 0, 1, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (14, N'hrd@astra.life.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 2, 0, 1, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (15, N'hrd@ciputat.grn.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 2, 0, 0, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (16, N'fio@gmail.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 0, 0, 0, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (17, N'firda@gmail.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 1, 0, 0, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (18, NULL, N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 2, 0, 0, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (19, NULL, N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 1, 0, 0, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (20, NULL, N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 0, 0, 0, 0)
SET IDENTITY_INSERT [dbo].[UserLogin] OFF
GO
SET IDENTITY_INSERT [dbo].[VerifikasiPerusahaan] ON 

INSERT [dbo].[VerifikasiPerusahaan] ([id], [id_perusahaan], [npwp], [tdp], [siu], [hasil], [created_date], [last_modified], [diverifikasi_oleh], [komentar]) VALUES (1, 1, N'01.855.081.4-412.000', N'070721-025255-333.pdf', N'070721-025255-333.pdf', 1, CAST(N'2021-12-07' AS Date), CAST(N'2021-12-07' AS Date), N'Mochammad Rifqy', N'Sudah baik')
INSERT [dbo].[VerifikasiPerusahaan] ([id], [id_perusahaan], [npwp], [tdp], [siu], [hasil], [created_date], [last_modified], [diverifikasi_oleh], [komentar]) VALUES (2, 2, N'02.155.081.4-409.000', N'070721-025255-333.pdf', N'070721-025255-333.pdf', 1, CAST(N'2021-12-07' AS Date), CAST(N'2021-12-07' AS Date), N'Mochammad Rifqy', N'Sudah baik')
INSERT [dbo].[VerifikasiPerusahaan] ([id], [id_perusahaan], [npwp], [tdp], [siu], [hasil], [created_date], [last_modified], [diverifikasi_oleh], [komentar]) VALUES (3, 3, N'01.355.091.2-214.000', N'070721-025255-333.pdf', N'070721-025255-333.pdf', 1, CAST(N'2021-12-07' AS Date), CAST(N'2021-12-07' AS Date), N'Mochammad Rifqy', N'Sudah baik')
INSERT [dbo].[VerifikasiPerusahaan] ([id], [id_perusahaan], [npwp], [tdp], [siu], [hasil], [created_date], [last_modified], [diverifikasi_oleh], [komentar]) VALUES (4, 4, N'03.435.081.1-416.000', N'070721-025255-333.pdf', N'070721-025255-333.pdf', 1, CAST(N'2021-12-07' AS Date), CAST(N'2021-12-07' AS Date), N'Mochammad Rifqy', N'Sudah baik')
INSERT [dbo].[VerifikasiPerusahaan] ([id], [id_perusahaan], [npwp], [tdp], [siu], [hasil], [created_date], [last_modified], [diverifikasi_oleh], [komentar]) VALUES (5, 5, N'01.985.281.3-112.000', N'070721-025255-333.pdf', N'070721-025255-333.pdf', 0, CAST(N'2021-12-07' AS Date), CAST(N'2021-12-07' AS Date), N'Mochammad Rifqy', N'Dokumen tidak memenuhi')
INSERT [dbo].[VerifikasiPerusahaan] ([id], [id_perusahaan], [npwp], [tdp], [siu], [hasil], [created_date], [last_modified], [diverifikasi_oleh], [komentar]) VALUES (6, 6, N'01.125.131.4-552.000', N'070721-025255-333.pdf', N'070721-025255-333.pdf', 1, CAST(N'2021-12-07' AS Date), CAST(N'2021-12-07' AS Date), N'Mochammad Rifqy', N'Sudah baik')
INSERT [dbo].[VerifikasiPerusahaan] ([id], [id_perusahaan], [npwp], [tdp], [siu], [hasil], [created_date], [last_modified], [diverifikasi_oleh], [komentar]) VALUES (7, 7, N'02.345.081.2-332.000', N'070721-025255-333.pdf', N'070721-025255-333.pdf', 1, CAST(N'2021-07-13' AS Date), CAST(N'2021-07-13' AS Date), N'Mochammad Rifqy', N'Sudah baik')
INSERT [dbo].[VerifikasiPerusahaan] ([id], [id_perusahaan], [npwp], [tdp], [siu], [hasil], [created_date], [last_modified], [diverifikasi_oleh], [komentar]) VALUES (8, 8, N'01.335.081.3-412.000', N'070721-025255-333.pdf', N'070721-025255-333.pdf', 0, CAST(N'2021-07-13' AS Date), CAST(N'2021-07-13' AS Date), N'Mochammad Rifqy', N'Dokumen tidak memenuhi')
INSERT [dbo].[VerifikasiPerusahaan] ([id], [id_perusahaan], [npwp], [tdp], [siu], [hasil], [created_date], [last_modified], [diverifikasi_oleh], [komentar]) VALUES (9, 9, N'02.675.081.4-420.000', N'070721-025255-333.pdf', N'070721-025255-333.pdf', 1, CAST(N'2021-07-13' AS Date), CAST(N'2021-07-13' AS Date), N'Mochammad Rifqy', N'Sudah baik')
INSERT [dbo].[VerifikasiPerusahaan] ([id], [id_perusahaan], [npwp], [tdp], [siu], [hasil], [created_date], [last_modified], [diverifikasi_oleh], [komentar]) VALUES (10, 10, N'03.985.121.4-322.000', N'070721-025255-333.pdf', N'070721-025255-333.pdf', 1, CAST(N'2021-07-13' AS Date), CAST(N'2021-07-13' AS Date), N'Mochammad Rifqy', N'Sudah baik')
SET IDENTITY_INSERT [dbo].[VerifikasiPerusahaan] OFF
GO
ALTER TABLE [dbo].[Pengalaman] ADD  CONSTRAINT [DF_Pengalaman_file_attachment]  DEFAULT ('default.jpg') FOR [file_attachment]
GO
ALTER TABLE [dbo].[UserLogin] ADD  CONSTRAINT [DF_UserLogin_status]  DEFAULT ((1)) FOR [row_status]
GO
ALTER TABLE [dbo].[ConfirmationToken]  WITH CHECK ADD  CONSTRAINT [FK_ConfirmationToken_UserLogin] FOREIGN KEY([id_user])
REFERENCES [dbo].[UserLogin] ([id])
GO
ALTER TABLE [dbo].[ConfirmationToken] CHECK CONSTRAINT [FK_ConfirmationToken_UserLogin]
GO
ALTER TABLE [dbo].[Lamaran]  WITH CHECK ADD  CONSTRAINT [FK_Lamaran_Lowongan] FOREIGN KEY([id_lowongan])
REFERENCES [dbo].[Lowongan] ([id])
GO
ALTER TABLE [dbo].[Lamaran] CHECK CONSTRAINT [FK_Lamaran_Lowongan]
GO
ALTER TABLE [dbo].[Lamaran]  WITH CHECK ADD  CONSTRAINT [FK_Lamaran_Pelamar] FOREIGN KEY([id_pelamar])
REFERENCES [dbo].[Pelamar] ([id])
GO
ALTER TABLE [dbo].[Lamaran] CHECK CONSTRAINT [FK_Lamaran_Pelamar]
GO
ALTER TABLE [dbo].[Lowongan]  WITH CHECK ADD  CONSTRAINT [FK_Lowongan_JenisPegawai] FOREIGN KEY([id_jenis_pegawai])
REFERENCES [dbo].[JenisPegawai] ([id])
GO
ALTER TABLE [dbo].[Lowongan] CHECK CONSTRAINT [FK_Lowongan_JenisPegawai]
GO
ALTER TABLE [dbo].[Lowongan]  WITH CHECK ADD  CONSTRAINT [FK_Lowongan_Perusahaan] FOREIGN KEY([id_perusahaan])
REFERENCES [dbo].[Perusahaan] ([id])
GO
ALTER TABLE [dbo].[Lowongan] CHECK CONSTRAINT [FK_Lowongan_Perusahaan]
GO
ALTER TABLE [dbo].[Notifikasi]  WITH CHECK ADD  CONSTRAINT [FK_Notifikasi_Lamaran] FOREIGN KEY([id_lamaran])
REFERENCES [dbo].[Lamaran] ([id])
GO
ALTER TABLE [dbo].[Notifikasi] CHECK CONSTRAINT [FK_Notifikasi_Lamaran]
GO
ALTER TABLE [dbo].[Pendidikan]  WITH CHECK ADD  CONSTRAINT [FK_Pendidikan_Jenjang] FOREIGN KEY([id_jenjang])
REFERENCES [dbo].[Jenjang] ([id])
GO
ALTER TABLE [dbo].[Pendidikan] CHECK CONSTRAINT [FK_Pendidikan_Jenjang]
GO
ALTER TABLE [dbo].[Pendidikan]  WITH CHECK ADD  CONSTRAINT [FK_Pendidikan_Pelamar] FOREIGN KEY([id_pelamar])
REFERENCES [dbo].[Pelamar] ([id])
GO
ALTER TABLE [dbo].[Pendidikan] CHECK CONSTRAINT [FK_Pendidikan_Pelamar]
GO
/****** Object:  StoredProcedure [dbo].[eliminatePelamarByPendidikan]    Script Date: 7/15/2021 11:52:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[eliminatePelamarByPendidikan] @IdLowongan int
AS
UPDATE Lamaran SET status_lamaran = 1 WHERE id IN (
            SELECT id_lamaran FROM view_LamaranPelamar WHERE id_lowongan = @IdLowongan AND tingkatan_jenjang < jenjang_minimal AND status_lamaran = 0)
UPDATE Lamaran SET status_lamaran = 2 WHERE id IN (
            SELECT id_lamaran FROM view_LamaranPelamar WHERE id_lowongan = @IdLowongan AND tingkatan_jenjang > jenjang_minimal AND status_lamaran = 0)
GO
USE [master]
GO
ALTER DATABASE [Adagawe] SET  READ_WRITE 
GO

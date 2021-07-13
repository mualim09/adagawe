USE [master]
GO
/****** Object:  Database [Adagawe]    Script Date: 7/6/2021 8:08:47 PM ******/
CREATE DATABASE [Adagawe]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Adagawe', FILENAME = N'D:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Adagawe.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Adagawe_log', FILENAME = N'D:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Adagawe_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
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
/****** Object:  Table [dbo].[Admin]    Script Date: 7/6/2021 8:08:47 PM ******/
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
/****** Object:  Table [dbo].[ConfirmationToken]    Script Date: 7/6/2021 8:08:47 PM ******/
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
/****** Object:  Table [dbo].[Jabatan]    Script Date: 7/6/2021 8:08:47 PM ******/
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
/****** Object:  Table [dbo].[JenisPegawai]    Script Date: 7/6/2021 8:08:47 PM ******/
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
/****** Object:  Table [dbo].[Jenjang]    Script Date: 7/6/2021 8:08:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Jenjang](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nama_jenjang] [varchar](10) NULL,
	[deskripsi] [varchar](50) NULL,
	[tingkatan_jenjang] [int] NULL,
 CONSTRAINT [PK_Jenjang] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Lamaran]    Script Date: 7/6/2021 8:08:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Lamaran](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_pelamar] [int] NOT NULL,
	[id_lowongan] [int] NOT NULL,
	[tanggal_melamar] [date] NOT NULL,
	[pesan_pelamar] [varchar](255) NOT NULL,
	[resume] [varchar](50) NOT NULL,
	[status_lamaran] [int] NOT NULL,
 CONSTRAINT [PK_Lamaran] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Lowongan]    Script Date: 7/6/2021 8:08:47 PM ******/
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
/****** Object:  Table [dbo].[Pelamar]    Script Date: 7/6/2021 8:08:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pelamar](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nama_pelamar] [varchar](100) NULL,
	[tanggal_lahir] [date] NULL,
	[jenis_kelamin] [char](1) NULL,
	[no_telepon] [varchar](13) NULL,
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
/****** Object:  Table [dbo].[Pendidikan]    Script Date: 7/6/2021 8:08:47 PM ******/
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
/****** Object:  Table [dbo].[Pengalaman]    Script Date: 7/6/2021 8:08:47 PM ******/
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
/****** Object:  Table [dbo].[Perusahaan]    Script Date: 7/6/2021 8:08:47 PM ******/
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
 CONSTRAINT [PK_Perusahaan] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sertifikat]    Script Date: 7/6/2021 8:08:47 PM ******/
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
/****** Object:  Table [dbo].[UserLogin]    Script Date: 7/6/2021 8:08:47 PM ******/
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
/****** Object:  Table [dbo].[VerifikasiPerusahaan]    Script Date: 7/6/2021 8:08:47 PM ******/
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

INSERT [dbo].[Admin] ([id], [nama_admin], [tanggal_lahir], [jenis_kelamin], [no_telepon], [foto_profil], [row_status], [id_user_login]) VALUES (1, N'Mochammad Rifqy', CAST(N'2001-06-18' AS Date), N'L', N'089664467845', N'default-employee.jpg', 1, 5)
INSERT [dbo].[Admin] ([id], [nama_admin], [tanggal_lahir], [jenis_kelamin], [no_telepon], [foto_profil], [row_status], [id_user_login]) VALUES (2, N'Gais', CAST(N'2021-06-24' AS Date), N'L', N'34567876543', N'default-employee.png', 1, 6)
SET IDENTITY_INSERT [dbo].[Admin] OFF
GO
SET IDENTITY_INSERT [dbo].[ConfirmationToken] ON 

INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (1, 1, N'bdb2999a-8b0b-4a29-8a96-6573fb10ad15', CAST(N'2021-06-21T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (2, 2, N'd76e18ac-a169-458d-9c61-e617b2701d8c', CAST(N'2021-06-21T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (3, 3, N'6f2aec6b-212b-43c7-97d5-071a9b29fe91', CAST(N'2021-06-21T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (4, 4, N'30037657-f8e6-444e-94c9-a1cc6ba9716c', CAST(N'2021-06-21T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (5, 5, N'284c6358-3dd0-4f3b-b636-c34240be7b6f', CAST(N'2021-06-22T00:00:00.000' AS DateTime))
INSERT [dbo].[ConfirmationToken] ([id], [id_user], [confirmation_token], [created_date]) VALUES (6, 6, N'dc7d74cb-1a5a-466b-9717-a2ff73d15d9d', CAST(N'2021-06-24T00:00:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[ConfirmationToken] OFF
GO
SET IDENTITY_INSERT [dbo].[Jabatan] ON 

INSERT [dbo].[Jabatan] ([id], [nama_jabatan], [deskripsi], [row_status]) VALUES (1, N'Software Developer', N'-', 1)
INSERT [dbo].[Jabatan] ([id], [nama_jabatan], [deskripsi], [row_status]) VALUES (2, N'Database Administrator', NULL, 1)
INSERT [dbo].[Jabatan] ([id], [nama_jabatan], [deskripsi], [row_status]) VALUES (3, N'IT Support', NULL, 1)
INSERT [dbo].[Jabatan] ([id], [nama_jabatan], [deskripsi], [row_status]) VALUES (4, N'Senior Programmer', NULL, 1)
INSERT [dbo].[Jabatan] ([id], [nama_jabatan], [deskripsi], [row_status]) VALUES (5, N'System Analyst', NULL, 1)
INSERT [dbo].[Jabatan] ([id], [nama_jabatan], [deskripsi], [row_status]) VALUES (6, N'Network Architect', NULL, 1)
INSERT [dbo].[Jabatan] ([id], [nama_jabatan], [deskripsi], [row_status]) VALUES (7, N'Web Developer', NULL, 1)
INSERT [dbo].[Jabatan] ([id], [nama_jabatan], [deskripsi], [row_status]) VALUES (8, N'UI/UX Designer', NULL, 1)
SET IDENTITY_INSERT [dbo].[Jabatan] OFF
GO
SET IDENTITY_INSERT [dbo].[JenisPegawai] ON 

INSERT [dbo].[JenisPegawai] ([id], [jenis_pegawai], [row_status]) VALUES (1, N'Full-time', 1)
INSERT [dbo].[JenisPegawai] ([id], [jenis_pegawai], [row_status]) VALUES (2, N'Part-time', 1)
INSERT [dbo].[JenisPegawai] ([id], [jenis_pegawai], [row_status]) VALUES (3, N'Freelance', 1)
INSERT [dbo].[JenisPegawai] ([id], [jenis_pegawai], [row_status]) VALUES (4, N'Contract', 1)
SET IDENTITY_INSERT [dbo].[JenisPegawai] OFF
GO
SET IDENTITY_INSERT [dbo].[Jenjang] ON 

INSERT [dbo].[Jenjang] ([id], [nama_jenjang], [deskripsi], [tingkatan_jenjang]) VALUES (1, N'SD', N'Sekolah Dasar', 1)
INSERT [dbo].[Jenjang] ([id], [nama_jenjang], [deskripsi], [tingkatan_jenjang]) VALUES (2, N'SMP', N'Sekolah Menengah Pertama', 2)
INSERT [dbo].[Jenjang] ([id], [nama_jenjang], [deskripsi], [tingkatan_jenjang]) VALUES (3, N'SMK', N'Sekolah Menengah Kejurusan', 3)
INSERT [dbo].[Jenjang] ([id], [nama_jenjang], [deskripsi], [tingkatan_jenjang]) VALUES (4, N'SMA', N'Sekolah Menengah Atas', 3)
INSERT [dbo].[Jenjang] ([id], [nama_jenjang], [deskripsi], [tingkatan_jenjang]) VALUES (5, N'D3', N'Diploma III', 4)
INSERT [dbo].[Jenjang] ([id], [nama_jenjang], [deskripsi], [tingkatan_jenjang]) VALUES (6, N'D4', N'Diplova IV', 5)
INSERT [dbo].[Jenjang] ([id], [nama_jenjang], [deskripsi], [tingkatan_jenjang]) VALUES (7, N'S1', N'Sarjana', 5)
INSERT [dbo].[Jenjang] ([id], [nama_jenjang], [deskripsi], [tingkatan_jenjang]) VALUES (8, N'S2', N'Magister', 6)
INSERT [dbo].[Jenjang] ([id], [nama_jenjang], [deskripsi], [tingkatan_jenjang]) VALUES (9, N'S3', N'Doctor', 7)
SET IDENTITY_INSERT [dbo].[Jenjang] OFF
GO
SET IDENTITY_INSERT [dbo].[Lamaran] ON 

INSERT [dbo].[Lamaran] ([id], [id_pelamar], [id_lowongan], [tanggal_melamar], [pesan_pelamar], [resume], [status_lamaran]) VALUES (2, 1, 1, CAST(N'2021-07-06' AS Date), N'', N'060721-075720-390.pdf', 0)
SET IDENTITY_INSERT [dbo].[Lamaran] OFF
GO
SET IDENTITY_INSERT [dbo].[Lowongan] ON 

INSERT [dbo].[Lowongan] ([id], [id_perusahaan], [id_jenis_pegawai], [judul_lowongan], [keterangan], [gaji_minimal], [gaji_maksimal], [pengalaman_kerja], [keahlian], [sembunyikan_gaji], [status], [created_date], [last_modified]) VALUES (1, 1, 1, N'Front-End Developer', N'asdasd', 5000000, 10000000, N'1 - 3 tahun', N'Spring, Laravel, React.js', 0, 1, CAST(N'2021-06-30' AS Date), CAST(N'2021-07-02' AS Date))
INSERT [dbo].[Lowongan] ([id], [id_perusahaan], [id_jenis_pegawai], [judul_lowongan], [keterangan], [gaji_minimal], [gaji_maksimal], [pengalaman_kerja], [keahlian], [sembunyikan_gaji], [status], [created_date], [last_modified]) VALUES (2, 2, 2, N'Back-End Developer', N'asdasd', 6000000, 9000000, N'< 1 tahun', N'Node.js, Lumen', 0, 1, CAST(N'2021-06-30' AS Date), CAST(N'2021-07-02' AS Date))
SET IDENTITY_INSERT [dbo].[Lowongan] OFF
GO
SET IDENTITY_INSERT [dbo].[Pelamar] ON 

INSERT [dbo].[Pelamar] ([id], [nama_pelamar], [tanggal_lahir], [jenis_kelamin], [no_telepon], [dokumen_cv], [id_user_login], [foto_profil], [row_status]) VALUES (1, N'puram', CAST(N'2021-06-25' AS Date), N'1', N'082380535032', NULL, 1, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Pelamar] OFF
GO
SET IDENTITY_INSERT [dbo].[Pendidikan] ON 

INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (1, 1, 5, N'Sistem Informasi', N'Politeknik Astra International', N'2015', N'2019', 1)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (2, 1, 7, N'Teknik Informatika', N'Universitas Binus', N'2019', N'2021', 1)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (3, 1, 8, N'Teknik Informatika', N'Universitas Indonesia', N'2022', N'2025', 1)
INSERT [dbo].[Pendidikan] ([id], [id_pelamar], [id_jenjang], [nama_jurusan], [nama_universitas], [tahun_mulai], [tahun_selesai], [row_status]) VALUES (4, 1, 8, N'Teknik Informatika', N'Universitas Binus', N'2022', N'2025', 0)
SET IDENTITY_INSERT [dbo].[Pendidikan] OFF
GO
SET IDENTITY_INSERT [dbo].[Pengalaman] ON 

INSERT [dbo].[Pengalaman] ([id], [id_pelamar], [id_jabatan], [id_jenis_pegawai], [nama_perusahaan], [mulai_kerja], [terakhir_kerja], [deskripsi], [file_attachment], [row_status]) VALUES (13, 1, 1, 2, N'BlueBird Indonesian', CAST(N'2021-06-22' AS Date), CAST(N'2021-08-17' AS Date), NULL, NULL, 0)
INSERT [dbo].[Pengalaman] ([id], [id_pelamar], [id_jabatan], [id_jenis_pegawai], [nama_perusahaan], [mulai_kerja], [terakhir_kerja], [deskripsi], [file_attachment], [row_status]) VALUES (14, 1, 6, 1, N'Google Indonesia', CAST(N'2021-08-22' AS Date), CAST(N'2021-10-22' AS Date), N'', NULL, 1)
INSERT [dbo].[Pengalaman] ([id], [id_pelamar], [id_jabatan], [id_jenis_pegawai], [nama_perusahaan], [mulai_kerja], [terakhir_kerja], [deskripsi], [file_attachment], [row_status]) VALUES (15, 1, 1, 3, N'GOJEK', CAST(N'2021-06-24' AS Date), CAST(N'2021-06-25' AS Date), NULL, NULL, 1)
INSERT [dbo].[Pengalaman] ([id], [id_pelamar], [id_jabatan], [id_jenis_pegawai], [nama_perusahaan], [mulai_kerja], [terakhir_kerja], [deskripsi], [file_attachment], [row_status]) VALUES (16, 1, 1, 1, N'BlueBird Indonesian', CAST(N'2021-06-23' AS Date), CAST(N'2021-06-23' AS Date), NULL, NULL, 1)
SET IDENTITY_INSERT [dbo].[Pengalaman] OFF
GO
SET IDENTITY_INSERT [dbo].[Perusahaan] ON 

INSERT [dbo].[Perusahaan] ([id], [nama_perusahaan], [alamat_lengkap], [provinsi], [kota], [telah_terverifikasi], [foto_profil], [bidang_perusahaan], [row_status]) VALUES (1, N'Tokopedia', N'Jl. Dummy', N'Jakarta', N'Jakarta Utara', 1, N'default.png', N'Startup IT', 1)
INSERT [dbo].[Perusahaan] ([id], [nama_perusahaan], [alamat_lengkap], [provinsi], [kota], [telah_terverifikasi], [foto_profil], [bidang_perusahaan], [row_status]) VALUES (2, N'PT Astra Graphia Information Technology', N'Jl. Dummy', N'Jakarta', N'Jakarta Utara', 1, N'default.png', N'Computer Networking', 1)
SET IDENTITY_INSERT [dbo].[Perusahaan] OFF
GO
SET IDENTITY_INSERT [dbo].[Sertifikat] ON 

INSERT [dbo].[Sertifikat] ([id], [id_pelamar], [judul], [no_sertifikat], [berlaku_mulai], [berlaku_sampai], [file_attachment], [row_status]) VALUES (2, 1, N'Fundamental Programming Beginner', N'2001-2021', CAST(N'2014-06-18' AS Date), CAST(N'2018-06-18' AS Date), N'fsdfdsfdsgdgdfgfg', 1)
INSERT [dbo].[Sertifikat] ([id], [id_pelamar], [judul], [no_sertifikat], [berlaku_mulai], [berlaku_sampai], [file_attachment], [row_status]) VALUES (3, 1, N'Fundamental Programming Expertz', N'1431-1233e343', CAST(N'2021-06-23' AS Date), CAST(N'2024-06-23' AS Date), N'asddsfdsgdfgdf', 1)
INSERT [dbo].[Sertifikat] ([id], [id_pelamar], [judul], [no_sertifikat], [berlaku_mulai], [berlaku_sampai], [file_attachment], [row_status]) VALUES (4, 1, N'Fundamental Programming Expertfd', N'2001-2021', CAST(N'2021-06-23' AS Date), CAST(N'2021-06-23' AS Date), N'asddsfdsgdfgdf', 0)
SET IDENTITY_INSERT [dbo].[Sertifikat] OFF
GO
SET IDENTITY_INSERT [dbo].[UserLogin] ON 

INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (1, N'samodra.me@gmail.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 1, 0, 1, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (2, N'puramdanii@gmail.com', N'$2a$10$CeA0nPOttQX8UytmtRK9uewNeQ0YrbFZr3am7bxOhczhXryqm2zYW', 1, 0, 0, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (3, N'puramdanii@gmail.com', N'$2a$10$mZP4FwEfNA6soAtgMBxeCOosks6pz44rDmG9Ub43EA16Ul9LS2Nbe', 1, 0, 0, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (4, N'putriramadani.rais@gmail.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 2, 0, 1, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (5, N'muhrifh@gmail.com', N'$2a$10$vndr1mFEcSArOlsOiZhVteMBcTgfVSPjeMpvbuE2T4vglTn7bEleK', 0, 0, 1, 0)
INSERT [dbo].[UserLogin] ([id], [email], [password], [user_role], [locked], [enabled], [row_status]) VALUES (6, N'gais.staff@gmail.com', N'$2a$10$FpkxxsLaB3w/CuMA2F6wceJaEzn348wAbDpTf4MdIbMhA2dSHI0Rm', 0, 0, 0, 0)
SET IDENTITY_INSERT [dbo].[UserLogin] OFF
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
ALTER TABLE [dbo].[Pengalaman]  WITH CHECK ADD  CONSTRAINT [FK_Pengalaman_Jabatan] FOREIGN KEY([id_jabatan])
REFERENCES [dbo].[Jabatan] ([id])
GO
ALTER TABLE [dbo].[Pengalaman] CHECK CONSTRAINT [FK_Pengalaman_Jabatan]
GO
ALTER TABLE [dbo].[Pengalaman]  WITH CHECK ADD  CONSTRAINT [FK_Pengalaman_JenisPegawai] FOREIGN KEY([id_jenis_pegawai])
REFERENCES [dbo].[JenisPegawai] ([id])
GO
ALTER TABLE [dbo].[Pengalaman] CHECK CONSTRAINT [FK_Pengalaman_JenisPegawai]
GO
ALTER TABLE [dbo].[Pengalaman]  WITH CHECK ADD  CONSTRAINT [FK_Pengalaman_Pelamar] FOREIGN KEY([id_pelamar])
REFERENCES [dbo].[Pelamar] ([id])
GO
ALTER TABLE [dbo].[Pengalaman] CHECK CONSTRAINT [FK_Pengalaman_Pelamar]
GO
USE [master]
GO
ALTER DATABASE [Adagawe] SET  READ_WRITE 
GO

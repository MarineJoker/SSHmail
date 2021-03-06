USE [shop]
GO
/****** Object:  Table [dbo].[account1]    Script Date: 2017/9/11 23:21:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[account1](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[login] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[pass] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[category]    Script Date: 2017/9/11 23:21:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[category](
	[eid] [int] IDENTITY(1,1) NOT NULL,
	[type] [varchar](255) NULL,
	[hot] [varchar](255) NULL,
	[cid] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[eid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[forder]    Script Date: 2017/9/11 23:21:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[forder](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NULL,
	[phone] [varchar](255) NULL,
	[remark] [varchar](255) NULL,
	[timestamp] [datetime] NULL,
	[total] [float] NULL,
	[post] [varchar](255) NULL,
	[address] [varchar](255) NULL,
	[uid] [int] NULL,
	[sid] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[product]    Script Date: 2017/9/11 23:21:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NULL,
	[price] [float] NULL,
	[pic] [varchar](255) NULL,
	[remark] [varchar](255) NULL,
	[xremark] [varchar](255) NULL,
	[date] [datetime] NULL,
	[commend] [bit] NULL,
	[open1] [bit] NULL,
	[eid] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[sorder]    Script Date: 2017/9/11 23:21:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[sorder](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NULL,
	[price] [float] NULL,
	[number] [int] NULL,
	[pid] [int] NULL,
	[fid] [int] NULL,
	[index_] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[status]    Script Date: 2017/9/11 23:21:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[status](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[status] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[users]    Script Date: 2017/9/11 23:21:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[login] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[pass] [varchar](255) NULL,
	[sex] [varchar](255) NULL,
	[phone] [varchar](255) NULL,
	[email] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[category]  WITH CHECK ADD  CONSTRAINT [FK_ar5g592u2i15ow076itdhaq65] FOREIGN KEY([cid])
REFERENCES [dbo].[account1] ([id])
GO
ALTER TABLE [dbo].[category] CHECK CONSTRAINT [FK_ar5g592u2i15ow076itdhaq65]
GO
ALTER TABLE [dbo].[forder]  WITH CHECK ADD  CONSTRAINT [FK_aoobon44tlcydxoc1ydh5s6bh] FOREIGN KEY([sid])
REFERENCES [dbo].[status] ([id])
GO
ALTER TABLE [dbo].[forder] CHECK CONSTRAINT [FK_aoobon44tlcydxoc1ydh5s6bh]
GO
ALTER TABLE [dbo].[forder]  WITH CHECK ADD  CONSTRAINT [FK_eyr9whcv883x0uvkho0rbt40c] FOREIGN KEY([uid])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[forder] CHECK CONSTRAINT [FK_eyr9whcv883x0uvkho0rbt40c]
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FK_sb0358o8hjnv62iuil70hq3w] FOREIGN KEY([eid])
REFERENCES [dbo].[category] ([eid])
GO
ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FK_sb0358o8hjnv62iuil70hq3w]
GO
ALTER TABLE [dbo].[sorder]  WITH CHECK ADD  CONSTRAINT [FK_4t3k2jpnnxs5cf2pmbxl37ywq] FOREIGN KEY([fid])
REFERENCES [dbo].[forder] ([id])
GO
ALTER TABLE [dbo].[sorder] CHECK CONSTRAINT [FK_4t3k2jpnnxs5cf2pmbxl37ywq]
GO
ALTER TABLE [dbo].[sorder]  WITH CHECK ADD  CONSTRAINT [FK_mffyouwemywc2pv7jfgiurt1x] FOREIGN KEY([pid])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[sorder] CHECK CONSTRAINT [FK_mffyouwemywc2pv7jfgiurt1x]
GO

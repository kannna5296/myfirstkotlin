CREATE TABLE [dbo].[diary](
    [id] [int] IDENTITY(1, 1) NOT NULL,
    [author_name] [nvarchar](50) NOT NULL,
    [content] [nvarchar](140) NOT NULL,
    [created_at] [datetime2](2) NOT NULL,
    [updated_at] [datetime2](2) NOT NULL,
    PRIMARY KEY CLUSTERED([id] ASC) WITH(
        PAD_INDEX = OFF,
        STATISTICS_NORECOMPUTE = OFF,
        IGNORE_DUP_KEY = OFF,
        ALLOW_ROW_LOCKS =
    ON,
        ALLOW_PAGE_LOCKS =
    ON
    )
ON  [PRIMARY]
)
ON  [PRIMARY]
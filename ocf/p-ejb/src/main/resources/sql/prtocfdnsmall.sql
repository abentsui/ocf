drop procedure if exists prtocfdnsmall;

DELIMITER $$

CREATE PROCEDURE prtocfdnsmall(
	IN dnid longtext
)
BEGIN
	select a.id, a.code, b.ocfRecipient, b.ocfSender, b.ocfMessageContent, b.cardSize
	from maindn a, remdn b 
	where a.id = b.hId
		and a.id in (dnid);
END$$

DELIMITER ;
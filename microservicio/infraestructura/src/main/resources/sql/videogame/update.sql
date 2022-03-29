update videogame
set title = :title,
	companyId = :companyId,
	platform = :platform,
	releaseDate = :releaseDate,
	price = :price,
	stock = :stock
where videogame_id = :id
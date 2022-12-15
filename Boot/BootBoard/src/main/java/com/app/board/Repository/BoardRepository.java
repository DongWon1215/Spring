package com.app.board.Repository;

import com.app.board.Domain.BoardDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardDTO, Integer>
{
}

package jp.thinkware.tokumon.app.dao;

import java.util.List;
import java.util.Map;

import jp.thinkware.tokumon.app.dto.CourseDto;

/**
 * DBレコードのDAOインターフェースクラスです。(コース情報テーブル)
 * @author thinkware
 */
public interface CourseDao {

	/**
	 * DBにレコードを新規追加します。
	 * @param dto データオブジェクト
	 * @return 行ID
	 */
	public Long insert(CourseDto dto);

	/**
	 * DBのレコードを更新します。
	 * @param dto データオブジェクト
	 * @return なし
	 */
	public void update(CourseDto dto);

	/**
	 * DBのレコードを削除します。
	 * @param dto データオブジェクト
	 * @return なし
	 */
	public void delete(CourseDto dto);

	/**
	 * DBのレコードを削除します。
	 * @param conditionMap 抽出条件マップ
	 * @return なし
	 */
	public void delete(Map<String, Object> conditionMap);

	/**
	 * DBのレコードを抽出します。
	 * @param conditionMap 抽出条件マップ
	 * @return データリスト
	 */
	public List<CourseDto> selectList(Map<String, Object> conditionMap);
}
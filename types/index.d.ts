interface RNAltitudeConverterStatic {
  /**
   * Get the delta between WGS84 and MSL at the specified location
   * @param {number} lat Coordinate latitude (deg)
   * @param {number} lon Coordinate longitude (deg)
   * @returns {Promise<number>}
   * @memberof RNAltitudeConverterStatic
   */
  getMSLAltitudeDelta(lat: Number,lon: number): Promise<number>;
}
export var RNAltitudeConverter: RNAltitudeConverterStatic;